package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User jack = new Millenials("Jack Sparrow");
        User michael =new YGeneration("Michael Spring");
        User louis = new ZGeneration("Louis Steek");

        //When
        String jackStrategy = jack.sharePost();
        System.out.println("Jack publishing on " + jackStrategy);
        String michaelStrategy = michael.sharePost();
        System.out.println("Michael publishing on " + michaelStrategy);
        String louisStrategy = louis.sharePost();
        System.out.println("Louis publishing on " + louisStrategy);

        //Then
        Assert.assertEquals("Facebook", jackStrategy);
        Assert.assertEquals("Twitter", michaelStrategy);
        Assert.assertEquals("Snapchat", louisStrategy);
    }

    @Test
    public void testIndividualSharingStrategy(){
        //Given
        User jack = new Millenials("Jack Sparrow");

        //when
        String jackStrategy = jack.sharePost();
        System.out.println("Jack publishing on " + jackStrategy);
        jack.setSocialPublisher(new TwitterPublisher());
        jackStrategy = jack.sharePost();
        System.out.println("Jack publishing on " + jackStrategy);

        //Then
        Assert.assertEquals("Twitter", jackStrategy);
    }
}
