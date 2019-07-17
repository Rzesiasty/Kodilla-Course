package com.kodilla.testing.shape;

public class Square implements Shape {
    private int a;
    private double area;
    private String name;

    public Square(int a, String name) {
        this.a = a;
        this.name = name;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        area = a * a;
        return area;
    }

}
