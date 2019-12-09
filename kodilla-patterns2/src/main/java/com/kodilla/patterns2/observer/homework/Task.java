package com.kodilla.patterns2.observer.homework;

public class Task {
    private final String studentName;
    private String taskName;

    public Task(String studentName, String taskName) {
        this.studentName = studentName;
        this.taskName = taskName;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getTaskName() {
        return taskName;
    }
}
