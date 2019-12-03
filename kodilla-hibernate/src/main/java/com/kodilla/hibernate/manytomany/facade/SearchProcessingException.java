package com.kodilla.hibernate.manytomany.facade;

public class SearchProcessingException extends Exception {

    public static String ERR_COMPANY_NOT_FOUND = "No company found with the given query";
    public static String ERR_EMPLOYEE_NOT_FOUND = "No employee found with the given query";

    public SearchProcessingException(String message) {
        super(message);
    }
}
