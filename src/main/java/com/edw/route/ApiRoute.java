package com.edw.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * <pre>
 *     com.edw.route.ApiRoute
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 27 Jun 2022 09:21
 */
@Component
public class ApiRoute extends RouteBuilder {

    @Override
    public void configure() {
        // say helloworld
        from("direct:getHelloWorld")
                .routeId("getHelloWorld")
                .tracing()
                .log("calling getHelloWorld")
                .process(exchange -> {
                    String name = (String) exchange.getIn().getBody();
                    exchange.getMessage().setBody(new HashMap<>(){{
                        put("hello", name);
                    }});
                })
                .end();
    }
}
