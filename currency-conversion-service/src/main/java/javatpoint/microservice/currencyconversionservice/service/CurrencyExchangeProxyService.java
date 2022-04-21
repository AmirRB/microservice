package javatpoint.microservice.currencyconversionservice.service;

import javatpoint.microservice.currencyconversionservice.entity.CurrencyConversionBean;
import javatpoint.microservice.currencyconversionservice.proxy.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CurrencyExchangeProxyService {


    @Autowired
    private CurrencyExchangeProxy proxy;


    public CurrencyConversionBean retrieveExchangeValue(String from, String to) {
        return proxy.retrieveExchangeValue(from, to);
    }
}
