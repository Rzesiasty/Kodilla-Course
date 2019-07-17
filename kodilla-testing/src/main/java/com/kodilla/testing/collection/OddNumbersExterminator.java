package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumbersExterminator {

    public ArrayList exterminate(ArrayList<Integer> numbers) {
        ArrayList<Integer> oddList = new ArrayList<>();
        for (int n = 0; n < numbers.size(); n++) {
            int number = numbers.get(n);
            if (!(number % 2 == 0)) {
                oddList.add(number);
            }
        }
        return oddList;
    }
}
