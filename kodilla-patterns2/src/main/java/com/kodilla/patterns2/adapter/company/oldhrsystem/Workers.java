package com.kodilla.patterns2.adapter.company.oldhrsystem;

public class Workers {
    private String[][] workers = {
            {"67582395124", "John", "Smith"},
            {"54582395124", "Ivone", "Novak"},
            {"69582395124", "Clare", "Pinkman"},
            {"89582395124", "Jessie", "White"},
            {"90582395124", "Walter", "Larson"}
    };

    private double[] salaries = {
            4500.00,
            3700.00,
            4350.00,
            9000.00,
            6200.00
    };

    public String getWorker(int n) {
        if (n > salaries.length) {
            return "";
        }
        return workers[n][0] + " ," + workers[n][1] + " ," + workers[n][2] + " ," + salaries[n];
    }

    public String[][] getWorkers() {
        return workers;
    }

    public double[] getSalaries() {
        return salaries;
    }
}
