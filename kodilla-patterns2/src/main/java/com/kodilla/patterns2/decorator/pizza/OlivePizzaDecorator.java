package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class OlivePizzaDecorator extends AbstractPizzaOrderDecorator {
    protected OlivePizzaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCoast() {
        return super.getCoast().add(new BigDecimal(4));
    }

    @Override
    public String components() {
        return super.components() + ", olives";
    }
}
