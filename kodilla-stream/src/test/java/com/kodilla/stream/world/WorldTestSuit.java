package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuit {
    @Test
    public void testGetPeopleQuantity(){
        //Given
        Country germany = new Country("Germany", new BigDecimal("5454684132135"));
        Country france = new Country("France", new BigDecimal("454132135464321321"));
        Country vietnam = new Country("Vietnam", new BigDecimal("54651321315456"));
        Country china =new Country("China", new BigDecimal("546546879841321"));

        Continent asia = new Continent("Asia");
        Continent europe = new Continent("Europe");

        asia.addCounty(vietnam);
        asia.addCounty(china);
        europe.addCounty(germany);
        europe.addCounty(france);

        World world = new World();
        world.addContinent(asia);
        world.addContinent(europe);

        //When
        BigDecimal sumOfPeopleInTheWorld = world.getPeopleQuantity();

        //Then
        BigDecimal expectedNumberOfPeople = new BigDecimal("454738788349610233");
        Assert.assertEquals(expectedNumberOfPeople, sumOfPeopleInTheWorld);

    }
}

