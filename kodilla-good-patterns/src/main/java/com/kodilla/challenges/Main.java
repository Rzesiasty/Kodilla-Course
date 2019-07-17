package com.kodilla.challenges;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        MovieStore movie = new MovieStore();

        String movieStore = movie.getMovies().entrySet().stream()
                .map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .collect(Collectors.joining("!"));

        System.out.println(movieStore);
    }
}
