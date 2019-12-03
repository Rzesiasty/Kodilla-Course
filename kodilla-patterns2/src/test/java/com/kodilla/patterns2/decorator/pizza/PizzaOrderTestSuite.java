package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PizzaOrderTestSuite {
    @Test
    public void testOrderPizzaWithExtraCheeseSalamiAndThinDoughGetCoast(){
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraCheeseDecorator(theOrder);
        theOrder = new SalamiPizzaDecorator(theOrder);
        theOrder = new ThinDoughPizzaDecorator(theOrder);

        //When
        BigDecimal theCoast = theOrder.getCoast();

        //Then
        assertEquals(new BigDecimal(29), theCoast);
    } @Test
    public void testOrderPizzaWithExtraCheeseSalamiAndThinDoughGetDescription(){
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraCheeseDecorator(theOrder);
        theOrder = new SalamiPizzaDecorator(theOrder);
        theOrder = new ThinDoughPizzaDecorator(theOrder);

        //When
        String description = theOrder.components();

        //Then
        assertEquals("Pizza dough with tomato sauce and cheese extra cheese, salami thin dough pizza",description);
    } @Test
    public void testOrderPizzaWithExtraCheeseOlivesAndMushroomsGetCoast(){
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraCheeseDecorator(theOrder);
        theOrder = new OlivePizzaDecorator(theOrder);
        theOrder = new SalamiPizzaDecorator(theOrder);
        theOrder = new MushroomsPizzaDecorator(theOrder);

        //When
        BigDecimal theCoast = theOrder.getCoast();

        //Then
        assertEquals(new BigDecimal(36), theCoast);
    } @Test
    public void testOrderPizzaWithExtraCheeseOlivesSalamiAndMushroomsGetDescription(){
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraCheeseDecorator(theOrder);
        theOrder = new OlivePizzaDecorator(theOrder);
        theOrder = new SalamiPizzaDecorator(theOrder);
        theOrder = new MushroomsPizzaDecorator(theOrder);

        //When
        String description = theOrder.components();

        //Then
        assertEquals("Pizza dough with tomato sauce and cheese extra cheese, olives, salami, mushrooms",description);
    }
}
