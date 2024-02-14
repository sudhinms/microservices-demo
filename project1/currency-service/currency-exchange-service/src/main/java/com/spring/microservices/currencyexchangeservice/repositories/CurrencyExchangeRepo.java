package com.spring.microservices.currencyexchangeservice.repositories;

import com.spring.microservices.currencyexchangeservice.dao.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepo extends JpaRepository<CurrencyExchange,Long> {
    CurrencyExchange findByFromAndTo(String from, String to);
}
