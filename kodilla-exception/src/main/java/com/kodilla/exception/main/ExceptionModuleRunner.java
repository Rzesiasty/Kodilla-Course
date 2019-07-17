package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;
import com.kodilla.exception.test.Flight;
import com.kodilla.exception.test.RouteNotFoundException;
import com.kodilla.exception.test.SearchForAirConnection;

public class ExceptionModuleRunner {
    public static void main(String arg[]) {

        FileReader fileReader = new FileReader();
        try {
            fileReader.readFile();
        } catch (FileReaderException e) {
            System.out.println("Problem with reading a file");
        }

        System.out.println("\n");

        //Exercise 8.4

        SearchForAirConnection searchForAirConnection = new SearchForAirConnection();

        Flight fromWarsawToLublin = new Flight("Lublin", "Warszawa");
        Flight fromWarsawToGdansk = new Flight("Warszawa", "Gdansk");
        Flight fromWarsawToCracow = new Flight("Warszawa", "Krakow");
        try {
            searchForAirConnection.findFlight(fromWarsawToLublin);
        } catch (RouteNotFoundException e) {
            System.out.println("1. The flight to "+ fromWarsawToLublin.getArrivalAirport() +" can`t be executed.");
        }
        try {
            searchForAirConnection.findFlight(fromWarsawToGdansk);
        } catch (RouteNotFoundException e) {
            System.out.println("2. The flight to "+ fromWarsawToGdansk.getArrivalAirport()+ " can`t be executed");
        }
        try{
            searchForAirConnection.findFlight(fromWarsawToCracow);
        }catch (RouteNotFoundException e){
            System.out.println("3. The flight to "+ fromWarsawToCracow.getArrivalAirport() +" can`t be executed");
        }
    }
}
