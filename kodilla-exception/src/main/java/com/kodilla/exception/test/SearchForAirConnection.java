package com.kodilla.exception.test;

import java.util.*;
import java.util.stream.Collectors;

public class SearchForAirConnection {
    //private boolean isAirportOnMap = true;

    public boolean checkIfExistAirport(List<String> airportSet, String comparedAirport) {
        return airportSet.stream()
                .anyMatch(n -> n.equals(comparedAirport));
    }

    public void findFlight(Flight flight) throws RouteNotFoundException {
        final HashMap<String, Boolean> airport = new HashMap<>();
        airport.put("Warszawa", true);
        airport.put("Krakow", true);
        airport.put("Lublin", false);
        airport.put("Deblin", true);
        airport.put("Gdansk", false);

        List<String> isAirportOnMap = airport.entrySet().stream()
                .filter(a->a.getValue()==Boolean.TRUE)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        if (checkIfExistAirport(isAirportOnMap, flight.getArrivalAirport())&& checkIfExistAirport(isAirportOnMap, flight.getDepartureAirport()))
        {
            System.out.println("You can flight from " + flight.getDepartureAirport() + " to " + flight.getArrivalAirport() + " airport");
        } else {
            throw new RouteNotFoundException();
        }
    }
}

