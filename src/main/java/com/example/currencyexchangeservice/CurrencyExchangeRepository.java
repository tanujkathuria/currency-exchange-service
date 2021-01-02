package com.example.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchangeValue,Long> {

    CurrencyExchangeValue findByFromAndTo(String from, String to);
}
