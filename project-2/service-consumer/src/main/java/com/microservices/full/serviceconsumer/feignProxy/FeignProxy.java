package com.microservices.full.serviceconsumer.feignProxy;

import com.microservices.full.serviceconsumer.dao.Customers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "service-provider")
public interface FeignProxy {

    @GetMapping("/service-provider/get-customer")
    public List<Customers> getCustomers();
}
