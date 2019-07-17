package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuit {
    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);

        //When
        double add = calculator.add(2, 4);
        double sub = calculator.sub(8, 5);
        double mul = calculator.mul(5, 5);
        double div = calculator.div(45, 9);


        //Then
        assertEquals(6, add, 2);
        assertEquals(3, sub, 2);
        assertEquals(25, mul, 2);
        assertEquals(5, div, 2);

    }
}
