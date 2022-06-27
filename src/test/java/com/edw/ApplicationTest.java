package com.edw;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <pre>
 *     com.edw.ApplicationTest
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 27 Jun 2022 11:10
 */
@DisplayName("01. Sanity Check")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTest {

    @Test
    @DisplayName("01. Testing the context load")
    public void test_contextLoads() {
    }

    @Test
    @DisplayName("02. Testing the main class")
    public void test_main() {
        Application.main(new String[] {});
    }

}
