package com.kodilla.testing.collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CollectionTestSuit {
    @Before
    public void before() {
        System.out.println("Test case: before");
    }

    @After
    public void after() {
        System.out.println("Test case: after");
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        ArrayList<Integer> normalArrayList = new ArrayList<>();
        normalArrayList.add(1);
        normalArrayList.add(2);
        normalArrayList.add(3);
        normalArrayList.add(4);

        //When
        ArrayList oddArrayExtract = exterminator.exterminate(normalArrayList);

        //Then
        ArrayList<Integer> oddList = new ArrayList<>();
        oddList.add(1);
        oddList.add(3);
        Assert.assertEquals(oddArrayExtract, oddList);
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        ArrayList<Integer> emptyArrayList = new ArrayList<>();

        //When
        ArrayList oddArrayExtract = exterminator.exterminate(emptyArrayList);

        //Then
        Assert.assertTrue(oddArrayExtract.isEmpty());
    }
}

