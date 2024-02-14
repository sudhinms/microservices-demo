package com.spring.microservices.limitsservice.controllers;

import com.spring.microservices.limitsservice.bean.Limits;
import com.spring.microservices.limitsservice.bean.User1;
import com.spring.microservices.limitsservice.config.Configuration;
import com.spring.microservices.limitsservice.config.ConfigurationForYaml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {
    @Autowired
    private Configuration config;
    @Autowired
    private ConfigurationForYaml forYaml;

    @GetMapping("/limits")
    public Limits getLimits(){
        return new Limits(config.getMinimum(),config.getMaximum());
    }

    @GetMapping("/user")
    public User1 getUser(){
        return new User1(forYaml.getId(),forYaml.getName());
    }
}
