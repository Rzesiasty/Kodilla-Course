package com.kodilla.testing.usertests;

import static org.junit.Assert.*;

public class UserTestsTest {

    private UserTests userTests;

    public void shortWorldTest(){
        //Given
        String shortWorld = "Hello";

        //When
        String string = userTests.shortWorld(shortWorld);

        //Then
        assertEquals("H3o", string);
    }
}