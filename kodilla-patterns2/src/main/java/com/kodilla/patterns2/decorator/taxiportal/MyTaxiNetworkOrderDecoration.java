package com.kodilla.patterns2.decorator.taxiportal;

import java.math.BigDecimal;

public class MyTaxiNetworkOrderDecoration extends AbstractTaxiOrderDecorator {
    protected MyTaxiNetworkOrderDecoration(TaxiOrder taxiOrder) {
        super(taxiOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(30));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " by MyTaxi Network";
    }
}
