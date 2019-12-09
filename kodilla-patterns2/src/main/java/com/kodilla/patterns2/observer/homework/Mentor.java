package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {
    private final String mentorName;
    private int addTaskCount;

    public Mentor(String mentorName) {
        this.mentorName = mentorName;
    }

    @Override
    public void addTaskToQueue(Student student, Task tasks) {
        System.out.println(mentorName + ": new task have been add to queue " + tasks.getTaskName() +
                " from: " + tasks.getStudentName() + "\n" +
                "(total: " + student.getTasks().size() + " tasks to review");
        addTaskCount++;
    }

    public String getMentorName() {
        return mentorName;
    }

    public int getAddTaskCount() {
        return addTaskCount;
    }
}
