package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HomeworkTestSuite {
    @Test
    public void addTaskToQueueTest(){
        //Given
        Student javaTaskQueue = new StudentJavaTaskQueue();
        Student javaScriptTaskQueue = new StudentJavaScriptTaskQueue();

        Mentor mentor1 = new Mentor("mentor1");
        Mentor mentor2 = new Mentor("mentor2");

        javaTaskQueue.registerObserver(mentor1);
        javaScriptTaskQueue.registerObserver(mentor2);

        //When
        javaTaskQueue.addTask(new Task("Student 1", "task 1"));
        javaTaskQueue.addTask(new Task("Student 2", "task 2"));
        javaTaskQueue.addTask(new Task("Student 1", "task 3"));
        javaScriptTaskQueue.addTask(new Task("studen 4", "task 4"));
        javaScriptTaskQueue.addTask(new Task("studen 4", "task 5"));


        //Then
        assertEquals(3, mentor1.getAddTaskCount());
        assertEquals(2, mentor2.getAddTaskCount());
    }
}
