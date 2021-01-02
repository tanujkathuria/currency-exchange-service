package com.example.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private Environment environment;

    @Autowired
    CurrencyExchangeRepository currencyExchangeRepository;


    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchangeValue  retrieveExchangeValue(@PathVariable String from, @PathVariable String to ){
        CurrencyExchangeValue currencyExchangeValue = currencyExchangeRepository.findByFromAndTo(from,to);
        currencyExchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return currencyExchangeValue;

    }
}
