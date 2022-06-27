package com.edw.route;

import org.apache.camel.CamelContext;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.apache.camel.test.spring.junit5.CamelSpringTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import java.util.HashMap;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <pre>
 *     com.edw.route.ApiRouteTest
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 27 Jun 2022 11:42
 */
@DisplayName("02. Camel Check")
@CamelSpringBootTest
@EnableAutoConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiRouteTest {

    @Autowired
    ProducerTemplate producerTemplate;

    @Test
    @DisplayName("01. Sanity check for testing producerTemplate")
    public void test_NotNullProductTemplate() {
        assertNotNull(producerTemplate);
    }

    @Test
    @DisplayName("02. Testing a successful HashMap when injecting a random name")
    public void test_CamelResponse() {

        String randomName = UUID.randomUUID().toString();
        HashMap hashMap = (HashMap) producerTemplate.requestBody("direct:getHelloWorld", randomName);

        assertNotNull(hashMap);
        assertEquals(randomName, hashMap.get("hello"));
    }
}
