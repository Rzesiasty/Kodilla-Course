package com.kodilla.stream.sand;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class SandStorageTestSuit {
    @Test
    public void testGetSandBeansQuantity(){
        //Given
        List<SandStorage> continents = new ArrayList<>();
        continents.add(new Europe());
        continents.add(new Asia());
        continents.add(new Africa());

        //When
        BigDecimal totalSand = BigDecimal.ONE;
        for(SandStorage continent: continents){
            totalSand = totalSand.multiply(continent.getSandBeansQuantity());
        }

        //Then
        BigDecimal expectedSand = new BigDecimal ("1");
        assertEquals(expectedSand, totalSand);
    }
    @Test
    public void testGetSandBeansQuantityWithReduce(){
        //Given
        List<SandStorage> continents = new ArrayList<>();
        continents.add(new Europe());
        continents.add(new Asia());
        continents.add(new Africa());

        //When
        BigDecimal totalSand = continents.stream()
                .map(SandStorage::getSandBeansQuantity)
                .reduce(BigDecimal.ONE, (multiply, current) -> multiply.multiply(current));

        //Then
        BigDecimal expectedSand = new BigDecimal(1);
        assertEquals(expectedSand, totalSand);
    }
}
