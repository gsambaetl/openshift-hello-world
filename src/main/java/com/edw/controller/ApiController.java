package com.edw.controller;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <pre>
 *     com.edw.controller.ApiController
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 27 Jun 2022 09:18
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ProducerTemplate template;

    @GetMapping("/v1/hello")
    public HashMap getHello(@RequestParam("name") String name) {
        return (HashMap) template.requestBody("direct:getHelloWorld", name);
    }
}
