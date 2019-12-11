package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BooksStatistic;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.Statistics;

import java.util.Map;

public class MedianAdaptee implements BooksStatistic {
    @Override
    public int averagePublicationYear(Map<BookSignature, Book> books) {
        Statistics theStatistic = new Statistics();
        return theStatistic.averagePublicationYear(books);
    }
    @Override
    public int medianPublicationYear(Map<BookSignature, Book> books) {
        Statistics theStatistic = new Statistics();
        return theStatistic.medianPublicationYear(books);
    }
}
