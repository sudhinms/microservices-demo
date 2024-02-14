package com.spring.microservices.apigateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class LoggingFilter implements GlobalFilter {

    // HERE WE CAN IMPLEMENT AUTHENTICATION AND AUTHORIZATION.

    @Override
    public Mono<Void> filter(ServerWebExchange exchange
                            ,GatewayFilterChain chain) {
        log.info("path received -> {}",exchange.getRequest().getPath());
        log.info(exchange.getRequest().toString());
        return chain.filter(exchange); // Allowing the requests to continue
    }
}
