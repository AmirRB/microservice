package com.javatpoint.microservices.currencyexchangeservice.repository;

import com.javatpoint.microservices.currencyexchangeservice.entity.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<ExchangeValue, Long> {

    ExchangeValue findByFromAndTo(String from,String to);

}
