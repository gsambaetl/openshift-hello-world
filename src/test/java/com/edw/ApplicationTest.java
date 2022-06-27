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
@SpringBootTest
public class ApplicationTest {

    @Test
    @DisplayName("Testing the context load")
    public void contextLoads() {
    }

    @Test
    @DisplayName("Testing the main class")
    public void main() {
        Application.main(new String[] {});
    }

}
