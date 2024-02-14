package com.spring.microservices.currencyexchangeservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CircuitBreakerController {

//    @Retry(name = "sampleApi",fallbackMethod = "defaultValues")
//    @CircuitBreaker(name = "sampleApi",fallbackMethod = "defaultValues")
//    @RateLimiter(name = "apiRateLimiter")
    @Bulkhead(name = "apiRateLimiter")
    @GetMapping("/sample-api")
    public String sampleApi(){
        log.info("sample-api called");
//        ResponseEntity<String> responce= new RestTemplate()
//                .getForEntity("localhost:8009/some-api",String.class);
//        return responce.getBody();
        return "sample api";
    }
    public String defaultValues(Exception e){
        return "fallback value";
    }
}
