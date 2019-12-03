package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ExtraCheeseDecorator extends AbstractPizzaOrderDecorator{
    protected ExtraCheeseDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCoast() {
        return super.getCoast().add(new BigDecimal(5));
    }

    @Override
    public String components() {
        return super.components() + " extra cheese";
    }
}
