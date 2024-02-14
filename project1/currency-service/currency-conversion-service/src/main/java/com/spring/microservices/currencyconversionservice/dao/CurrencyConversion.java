package com.spring.microservices.currencyconversionservice.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversion {

    private long id;
    private String from;
    private String to;
    private long quantity;
    private double conversionMultiple;
    private double totalCalculatedAmount;
    private String environment;
}
