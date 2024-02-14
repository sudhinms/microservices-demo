package com.microservices.full.serviceprovider.controller;

import com.microservices.full.serviceprovider.dao.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/service-provider")
public class HomeController {
    @GetMapping("/get-customer")
    public List<Customer> getCustomer(){
        ArrayList<Customer> customers=new ArrayList<>();
        customers.add(new Customer(1,"Nixon",32));
        customers.add(new Customer(2,"Roy",28));
        customers.add(new Customer(3,"Max",30));
        customers.add(new Customer(4,"Antony",32));
        return customers;
    }
    @GetMapping("/user")
    public Customer singleCustomer(){
        return new Customer(10,"rq",27);
    }
}
