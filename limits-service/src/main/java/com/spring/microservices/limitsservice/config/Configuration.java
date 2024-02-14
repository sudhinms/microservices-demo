package com.spring.microservices.limitsservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "limit-service")
@Data
public class Configuration {
    private int minimum;
    private int maximum;
}
