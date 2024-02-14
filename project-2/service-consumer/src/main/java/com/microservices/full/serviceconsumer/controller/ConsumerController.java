package com.microservices.full.serviceconsumer.controller;

import com.microservices.full.serviceconsumer.dao.Customers;
import com.microservices.full.serviceconsumer.feignProxy.FeignProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.ServiceRequestWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class ConsumerController {

//    @Autowired
    private FeignProxy proxy;

    @Autowired
    public ConsumerController(FeignProxy proxy) {
        this.proxy = proxy;
        log.info("parameter constructor...");
    }
//
//    public ConsumerController() {
//        log.info("default constructor...");
//    }

//    @Autowired
//    public void setProxy(FeignProxy proxy) {
//        log.info("setter method called....");
//        this.proxy = proxy;
//    }

    @GetMapping("/get-all-customers")
    public List<Customers> getAllCustomers(){
        log.info("getAllCustomers in Consumer executed...");
        return proxy.getCustomers();
    }
}
