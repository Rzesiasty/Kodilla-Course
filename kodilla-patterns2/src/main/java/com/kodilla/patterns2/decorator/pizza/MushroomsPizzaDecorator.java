package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class MushroomsPizzaDecorator extends AbstractPizzaOrderDecorator {
    protected MushroomsPizzaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCoast() {
        return super.getCoast().add(new BigDecimal(6));
    }

    @Override
    public String components() {
        return super.components() + ", mushrooms";
    }
}
