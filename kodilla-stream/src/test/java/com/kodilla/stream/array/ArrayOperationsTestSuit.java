package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuit {
    @Test
    public void testGetAverage(){
        //Given
        int[] number = new int[5];
        number[0] = 1;
        number[1] = 5;
        number[2] = 23;
        number[3] = 11;
        number[4] = 98;

        //When
        double average = ArrayOperations.getAverage(number);

        //Then
        Assert.assertEquals(5, number.length);
        Assert.assertEquals(27.6, average, 0);
    }
}