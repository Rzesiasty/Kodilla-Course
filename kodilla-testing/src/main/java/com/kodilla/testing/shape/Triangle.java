package com.kodilla.testing.shape;

public class Triangle implements Shape {
    private int a;
    private int h;
    private double area;
    private String name;

    public Triangle(int a, int h, String name) {
        this.a = a;
        this.h = h;
        this.name = name;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        area = a * h / 2;
        return area;
    }
}
