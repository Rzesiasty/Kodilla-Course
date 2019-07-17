package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args){
        SecondChallenge secondChallenge = new SecondChallenge();
        try{
            String result = secondChallenge.probablyIWillThrowException(2, 1);
        } catch (Exception e){
            System.out.println("calling an exception");
        } finally {
            System.out.println("calling function");
        }
    }
}
