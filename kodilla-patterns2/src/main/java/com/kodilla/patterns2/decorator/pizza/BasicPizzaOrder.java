package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BasicPizzaOrder implements PizzaOrder {
    @Override
    public BigDecimal getCoast() {
        return new BigDecimal(15);
    }

    @Override
    public String components() {
        return "Pizza dough with tomato sauce and cheese";
    }
}
