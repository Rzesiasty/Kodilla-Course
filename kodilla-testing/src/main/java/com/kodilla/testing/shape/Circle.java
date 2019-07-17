package com.kodilla.testing.shape;

public class Circle implements Shape {
    private int radius;
    private double area;
    private String name;

    public Circle(int radius, String name) {
        this.radius = radius;
        this.name = name;
    }

    @Override
    public double getField() {
        area = (Math.PI * (Math.pow(radius, 2)));
        return area;
    }

    @Override
    public String getShapeName() {
        return name;
    }
}
