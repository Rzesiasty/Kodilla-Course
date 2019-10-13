package com.kodilla.testing.usertests;

public class UserTests {

    private String shortWorld = "";

    public String shortWorld(String shortWorld) {
        int count = shortWorld.length();
        return shortWorld.substring(0, 1) + count + shortWorld.substring(count - 1, count);
    }
}
