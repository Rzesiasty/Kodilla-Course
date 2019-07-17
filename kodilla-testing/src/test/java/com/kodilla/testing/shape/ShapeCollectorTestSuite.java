package com.kodilla.testing.shape;

import org.junit.*;

import java.util.ArrayList;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing o execute test #" + testCounter);
    }

    @Test
    public void testAddFigure() {
        //Given
        ShapeCollector collector = new ShapeCollector();
        Circle c = new Circle(2, "Circle");
        Square s = new Square(2, "Square");
        Triangle t = new Triangle(2, 3, "Triangle");

        //When
        collector.addFigure(c);
        collector.addFigure(s);
        collector.addFigure(t);

        //Then
        Assert.assertEquals(collector.getSize(), 3);
    }

    @Test
    public void testRemoveFigure() {
        //Given
        ShapeCollector collector = new ShapeCollector();
        Circle c = new Circle(2, "Circle");
        Square s = new Square(2, "Square");
        Triangle t = new Triangle(2, 3, "Triangle");
        collector.addFigure(c);
        collector.addFigure(s);
        collector.addFigure(t);

        //When
        collector.removeFigure(c);

        //Then
        Assert.assertEquals(collector.getSize(), 2);
    }
    @Test
    public void testGetFigure() {
        //Given
        ShapeCollector collector = new ShapeCollector();
        Circle c = new Circle(2, "Circle");
        Square s = new Square(2, "Square");
        Triangle t = new Triangle(2, 3, "Triangle");
        collector.addFigure(c);
        collector.addFigure(s);
        collector.addFigure(t);
        //When
        String retrievedFigure = collector.getFigure(2);
        //Then
        Assert.assertEquals("Triangle3.0", retrievedFigure);
    }
    @Test
    public void TestShowFigures(){
        //Given
        ShapeCollector collector = new ShapeCollector();
        Circle c = new Circle(2, "Circle");
        Square s = new Square(2, "Square");
        Triangle t = new Triangle(2, 3, "Triangle");
        collector.addFigure(c);
        collector.addFigure(s);
        collector.addFigure(t);
        //When
        collector.showFigures();
        String retrievedFigure = collector.getFigure(2);
        //Then
        Assert.assertEquals("Triangle3.0", retrievedFigure);
    }
}
