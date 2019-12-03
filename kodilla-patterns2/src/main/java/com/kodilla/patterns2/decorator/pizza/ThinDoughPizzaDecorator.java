package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ThinDoughPizzaDecorator extends AbstractPizzaOrderDecorator {
    protected ThinDoughPizzaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCoast() {
        return super.getCoast().add(new BigDecimal(3));
    }

    @Override
    public String components() {
        return super.components() + " thin dough pizza";
    }
}
