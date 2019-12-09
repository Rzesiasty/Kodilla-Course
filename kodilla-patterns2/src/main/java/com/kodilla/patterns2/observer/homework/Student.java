package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class Student implements Observable{
    private final String studentName;
    private final List<Observer> observers;
    private final List<Task> tasks;

    public Student(String studentName) {
        this.studentName = studentName;
        observers = new ArrayList<>();
        tasks = new ArrayList<>();
    }

    public void addTask(Task task){
        tasks.add(task);
        notifyObserver(task);
    }

    @Override
    public void registerObserver(Observer observer) {
    observers.add(observer);
    }

    @Override
    public void notifyObserver(Task task) {
        for (Observer observer: observers){
            observer.addTaskToQueue(this, task);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
    observers.remove(observer);
    }

    public String getStudentName() {
        return studentName;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
