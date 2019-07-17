package com.kodilla.exception.test;

import java.util.stream.Stream;

public class FirstChallenge {
    public double divide (double a, double b) throws ArithmeticException{
        if(b==0){
            throw new ArithmeticException();
        }
        return a/b;
    }

    public static void main(String[] args){
        FirstChallenge firstChallenge = new FirstChallenge();
        try {
            double result = firstChallenge.divide(3,0);
            System.out.println(result);
        } catch (ArithmeticException e){
            System.out.println("Can`t be divided by 0");
        }finally {
            System.out.println("Remember don`t divide by 0");
        }
    }
}
