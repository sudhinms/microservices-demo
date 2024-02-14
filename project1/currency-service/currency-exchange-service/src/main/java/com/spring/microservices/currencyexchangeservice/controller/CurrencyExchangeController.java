package com.spring.microservices.currencyexchangeservice.controller;

import com.spring.microservices.currencyexchangeservice.dao.CurrencyExchange;
import com.spring.microservices.currencyexchangeservice.repositories.CurrencyExchangeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpHeaders;
import java.sql.SQLDataException;

@RestController
public class CurrencyExchangeController {
    @Autowired
    private Environment environment;
    @Autowired
    private CurrencyExchangeRepo repo;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from,
                                                  @PathVariable String to){
        CurrencyExchange currencyExchange = repo.findByFromAndTo(from,to);
        if(currencyExchange==null){
            throw new IllegalArgumentException("unable to find data");
        }
        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
        return currencyExchange;
    }
}
