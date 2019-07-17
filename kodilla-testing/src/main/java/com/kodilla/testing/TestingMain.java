package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {

        SimpleUser simpleUser = new SimpleUser("theForumUser", "John Smith");
        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        Calculator calculator = new Calculator();
        int resultAdd = calculator.add(190, 86);
        int resultSubtract = calculator.subtract(196, 117);
        if (resultAdd == 276) {
            System.out.println("Add test OK");
        } else {
            System.out.println("Add test Error!!");
        }
        if (resultSubtract == 79) {
            System.out.println("Subtract test OK");
        } else {
            System.out.println("Subtract test Error!!");
        }
    }
}
