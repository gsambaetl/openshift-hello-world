package com.edw.controller;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

/**
 * <pre>
 *     com.edw.controller.ApiControllerTest
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 27 Jun 2022 10:50
 */
@DisplayName("03. Controller Check")
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = this.port;
    }

    @Test
    @DisplayName("01. Testing a successful rest api with a random name")
    public void test_SuccessRequest() {

        String randomName = UUID.randomUUID().toString();

        given()
                .log()
                .all()
                .accept(MediaType.APPLICATION_JSON_VALUE)
            .when()
                .get(String.format("/api/v1/hello?name=%s", randomName))
            .then()
                .log()
                .all()
                .assertThat()
                    .statusCode(HttpStatus.SC_OK)
                .and()
                    .body("hello", is(randomName));
    }
}
