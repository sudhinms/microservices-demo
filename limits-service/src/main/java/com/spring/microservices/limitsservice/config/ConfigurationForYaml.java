package com.spring.microservices.limitsservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "users")
@Data
@Component
public class ConfigurationForYaml {
    private int id;
    private String name;
//    private List<User1> user;
}
