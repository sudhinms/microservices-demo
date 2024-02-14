package com.spring.microservices.currencyconversionservice.controller;

import com.spring.microservices.currencyconversionservice.dao.CurrencyConversion;
import com.spring.microservices.currencyconversionservice.proxy.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class CurrencyConversionController {
    @Autowired
    private CurrencyExchangeProxy proxy;
    @Autowired
    private Environment environment;

    //          _________RestTemplate________
    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable long quantity){

//        BigDecimal total=quantity*
        HashMap<String,String> uriVariables=new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);

        ResponseEntity<CurrencyConversion> response=new RestTemplate().getForEntity
                ("http://localhost:8001/currency-exchange/from/{from}/to/{to}"
                        ,CurrencyConversion.class,uriVariables);

        CurrencyConversion currencyConversion=response.getBody();
//        System.out.println(response.getStatusCode());
        return new CurrencyConversion(currencyConversion.getId(),from,to
                ,quantity,currencyConversion.getConversionMultiple()
                ,currencyConversion.getConversionMultiple()*quantity
                ,currencyConversion.getEnvironment()+" in RestTemplate");
    }

    //        _____________Feign_____________

    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversionFeign(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable long quantity){

        CurrencyConversion currencyConversion=proxy.retrieveExchangeValue(from,to);

        return new CurrencyConversion(currencyConversion.getId(),from,to
                ,quantity,currencyConversion.getConversionMultiple()
                ,currencyConversion.getConversionMultiple()*quantity
                ,currencyConversion.getEnvironment()+" in feign");
    }
}
