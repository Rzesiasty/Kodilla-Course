package com.kodilla.patterns2.observer.homework;

public interface Observable {
    void registerObserver(Observer observer);
    void notifyObserver(Task task);
    void removeObserver(Observer observer);
}
