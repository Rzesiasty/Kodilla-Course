package com.kodilla.patterns2.decorator.taxiportal;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class TaxiOrderTestSuite {
    @Test
    public void testBasicOrderGetCost() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();

        //When
        BigDecimal calculatedCost = theOrder.getCost();

        //Then
        assertEquals(new BigDecimal(5), calculatedCost);
    }

    @Test
    public void testBasicOrderGetDescription() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();

        //When
        String description = theOrder.getDescription();

        //When
        assertEquals("Drive a course", description);
    }

    @Test
    public void testTaxiNetworkGetCost() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);

        //When
        BigDecimal theCost = theOrder.getCost();

        //Then
        assertEquals(new BigDecimal(40), theCost);
    }

    @Test
    public void testTaxiNetworkGetDescription() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);

        //When
        String description = theOrder.getDescription();

        //Then
        assertEquals("Drive a course by Taxi Network", description);
    }

    @Test
    public void testMyTaxiWithChildSeatGetCoast() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new MyTaxiNetworkOrderDecoration(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);

        //When
        BigDecimal theCoast = theOrder.getCost();

        //Then
        assertEquals(new BigDecimal(37), theCoast);
    }

    @Test
    public void testMyTaxiWithChildSeatGetDescription() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new MyTaxiNetworkOrderDecoration(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);

        //When
        String description = theOrder.getDescription();

        //Then
        assertEquals("Drive a course by MyTaxi Network + child seat", description);
    }

    @Test
    public void testMyTaxiWithTwoChildSeatGetCoast() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new MyTaxiNetworkOrderDecoration(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);

        //When
        BigDecimal theCoast = theOrder.getCost();

        //Then
        assertEquals(new BigDecimal(39), theCoast);
    }

    @Test
    public void testMyTaxiWithTwoChildSeatGetDescription() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new MyTaxiNetworkOrderDecoration(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);

        //When
        String description = theOrder.getDescription();

        //Then
        assertEquals("Drive a course by MyTaxi Network + child seat + child seat", description);
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetCost() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        theOrder = new VipCarDecorator(theOrder);
        theOrder = new ExpressDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        System.out.println(theOrder.getCost());

        //When
        BigDecimal theCoast = theOrder.getCost();

        //Then
        assertEquals(new BigDecimal(57), theCoast);
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetDescription() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        theOrder = new VipCarDecorator(theOrder);
        theOrder = new ExpressDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        System.out.println(theOrder.getDescription());

        //When
        String description = theOrder.getDescription();

        //Then
        assertEquals("Drive a course by Taxi Network variant VIP express service + child seat", description);
    }
}
