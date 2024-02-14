package com.spring.microservices.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        return builder.routes()
                .route(request1->
                        request1
                                // REQUEST IS MATCHED HERE..
                                // WE CAN MATCH REQUEST BASED ON DIFFERENT WAYS (eg:- HEADER,HOST,COOKIE,..)
                                .path("/get/**")// predicate
                                .filters(f ->           // filter
                                        f.addRequestHeader("myHeader","myValue")
                                                .addRequestParameter("parameter1","paramValue")
                                )
                                .uri("http://httpbin.org:80"))
                .route(request2->
                        request2
                                .path("/currency-exchange/**")
                                .uri("lb://currency-exchange"))
                .route(request3->
                        request3
                                .path("/currency-conversion/**")
                                .uri("lb://currency-conversion"))
                //  URL rewriting
                .route(request4->
                        request4
                                .path("/currency-conversion-new/**")
                                .filters(f->f.rewritePath("/currency-conversion-new/(?<segment>.*)"
                                        ,"/currency-conversion-feign/${segment}"))
                                .uri("lb://currency-conversion"))
                .route(predicateSpec -> predicateSpec.path("/google")
                        .uri("https://www.google.com") )
                .build();
    }
}
