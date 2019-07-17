package com.kodilla.testing.shape;

import java.util.ArrayList;


public class ShapeCollector {
    private ArrayList<Shape> shapeCollection = new ArrayList<>();

    public void addFigure(Shape shape) {shapeCollection.add(shape);
    }

    public void removeFigure(Shape shape) {
        shapeCollection.remove(shape);
    }

    public String getFigure(int n) {
        return shapeCollection.get(n).getShapeName() + shapeCollection.get(n).getField();
    }

    public void showFigures() {
        for (int i = 0; i < shapeCollection.size(); i++) {
            System.out.println(shapeCollection.get(i).getShapeName() +
                    " field: " + shapeCollection.get(i).getField());
        }
    }

    public int getSize() {
        return shapeCollection.size();
    }

}

