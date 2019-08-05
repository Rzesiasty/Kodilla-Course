package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmacBuilder(){
        //Given
        Bigmac bigmac =new Bigmac.BigmacBuilder()
                .bunType("standard")
                .burgers(5)
                .sauce("1000 islands")
                .ingredient("mushrooms")
                .ingredient("cucumber")
                .ingredient("cheese")
                .ingredient("chili")
                .build();


        System.out.println(bigmac);
        //When
        String whatBun = bigmac.getBun();
        int howManyBurgers = bigmac.getBurgers();
        String whatKindOfSauce = bigmac.getSauce();
        int howManyIngredients = bigmac.getIngredients().size();
        //Then
        Assert.assertEquals("standard", whatBun);
        Assert.assertEquals(5, howManyBurgers);
        Assert.assertEquals("1000 islands", whatKindOfSauce);
        Assert.assertEquals(4, howManyIngredients);

    }
}
