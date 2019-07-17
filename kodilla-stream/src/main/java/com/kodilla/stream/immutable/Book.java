package com.kodilla.stream.immutable;

public final class Book {
    private final String title;
    private final String author;
    private final int yearOfPublicaton;

    public Book(final String title,final String author,final int yearOfPublicaton) {
        this.title = title;
        this.author = author;
        this.yearOfPublicaton = yearOfPublicaton;
    }
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublicaton() {
        return yearOfPublicaton;
    }
}
