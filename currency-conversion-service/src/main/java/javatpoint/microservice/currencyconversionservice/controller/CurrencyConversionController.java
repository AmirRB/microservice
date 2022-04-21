package javatpoint.microservice.currencyconversionservice.controller;

import javatpoint.microservice.currencyconversionservice.entity.CurrencyConversionBean;
import javatpoint.microservice.currencyconversionservice.service.CurrencyExchangeProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeProxyService serviceProxy;

    @GetMapping("/currency-converter/from/{from}/to/{to}/ quantity/{quantity}")
    //where {from} and {to} represents the column
    //return a bean back
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

        Map<String, String> variable = new HashMap<>();
        variable.put("from", from);
        variable.put("to", to);

        ResponseEntity<CurrencyConversionBean> template = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, variable);
        CurrencyConversionBean response = template.getBody();

        return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity, quantity.multiply(response.getConversionMultiple()), response.getPort());
    }


    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    //where {from} and {to} represents the column
    //return a bean back
    public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

        Map<String, String> variable = new HashMap<>();
        variable.put("from", from);
        variable.put("to", to);


        CurrencyConversionBean bean = serviceProxy.retrieveExchangeValue(from, to);
        bean.setQuantity(quantity);
        bean.setTotalCalculatedAmount(quantity.multiply(bean.getConversionMultiple()));

        return bean;
//
//        return new CurrencyConversionBean();
    }

}
