package com.javatpoint.microservices.currencyexchangeservice.entity;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity(name = "exchange_value")
@Table(name="Exchange_Value")
public class ExchangeValue {


    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="currency_from")
    private String from;

    @Column(name="currency_to")
    private String to;

    @Column(name="conversion_multiple")
    private BigDecimal conversionMultiple;

    @Column(name="port")
    private int port;

    public ExchangeValue() {
    }

    //generating constructor using fields
    public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple) {
        super();
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }

    //generating getters
    public Long getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public int getPort() {
        return port;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setPort(int port) {
        this.port = port;
    }
}


