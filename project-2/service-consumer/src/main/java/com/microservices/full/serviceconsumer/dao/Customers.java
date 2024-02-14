package com.microservices.full.serviceconsumer.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customers {
    private int id;
    private String name;
    private int age;
}
