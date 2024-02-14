package com.microservices.full.apigateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class RouteConfigurator {

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder){
        log.info("RouteLocator executed time : "+System.currentTimeMillis());
        return builder.routes()
                .route(route1->
                        route1.path("/service-provider/**")
                                .uri("lb://service-provider"))
                .route(route2->
                        route2.path("/single-user")
                                .filters(f->f.rewritePath(
                                        "/single-user",
                                        "/service-provider/user"
                                ))
                                .uri("lb://service-provider"))
                .route(route3->route3.path("/all-customers")
                        .filters(f->f.rewritePath("/all-customers","/get-all-customers")
                                .addRequestHeader("myHeader","myVal"))
                        .uri("lb://service-consumer"))
                .route(route1->
                        route1.path("/get/**")
                                .uri("http://httpbin.org:80"))
                .build();
    }
}
