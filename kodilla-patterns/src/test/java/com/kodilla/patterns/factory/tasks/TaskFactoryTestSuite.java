package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testFactoryShoppingTask(){
        //Given
        TaskFactory taskFactory = new TaskFactory();

        //When
        Task shoppingTask = taskFactory.makeTask(TaskFactory.SHOPPINGTASK);

        //Then
        Assert.assertEquals("Electronic store", shoppingTask.getTaskName());
        Assert.assertEquals("Product: Laptop quantity: 1.0", shoppingTask.executeTask());
        Assert.assertTrue(shoppingTask.isTaskExecuted());
    }

    @Test
    public void testFactoryPaintingTask(){
        //Given
        TaskFactory taskFactory = new TaskFactory();

        //When
        Task paintingTask = taskFactory.makeTask(TaskFactory.PAINTINGTASK);

        //Then
        Assert.assertEquals("Painting grandma house", paintingTask.getTaskName());
        Assert.assertEquals("Painting the wall in white color", paintingTask.executeTask());
        Assert.assertTrue(paintingTask.isTaskExecuted());
    }

    @Test
    public void testFactoryDrivingTask(){
        //Given
        TaskFactory taskFactory = new TaskFactory();

        //When
        Task drivingTask = taskFactory.makeTask(TaskFactory.DRIVINGTASK);

        //Then
        Assert.assertEquals("Driving car", drivingTask.getTaskName());
        Assert.assertEquals("Driving to warsaw by car", drivingTask.executeTask());
        Assert.assertTrue(drivingTask.isTaskExecuted());
    }
}
