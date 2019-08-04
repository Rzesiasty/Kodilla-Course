package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {
    public static final String SHOPPINGTASK = "SHOPPINGTASK";
    public static final String PAINTINGTASK = "PAINTINGTASK";
    public static final String DRIVINGTASK = "DRIVINGTASK";

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPINGTASK:
                return new ShoppingTask("Electronic store", "Laptop", 1);
            case PAINTINGTASK:
                return new PaintingTask("Painting grandma house", "white", "the wall");
            case DRIVINGTASK:
                return new DrivingTask("Driving car", "warsaw", "car");
            default:
                return null;
        }
    }
}
