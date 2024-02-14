package com.microservices.full.apigateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

//@Component
@Slf4j
@Configuration
public class LoggingFilter {
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        log.info("GlobalFilter executed time : "+System.currentTimeMillis());
//        log.info("path : "+exchange.getRequest().getPath());
//        return chain.filter(exchange);
//    }
    @Bean
    public GlobalFilter globalFilter(){
        return ((exchange, chain) -> {
            log.info("GlobalFilter executed time : "+System.currentTimeMillis());
            log.info("path : "+exchange.getRequest().getPath());
            return chain.filter(exchange);
        });
    }

}
