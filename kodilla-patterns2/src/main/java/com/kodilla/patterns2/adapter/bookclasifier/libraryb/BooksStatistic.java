package com.kodilla.patterns2.adapter.bookclasifier.libraryb;

import java.util.Map;

public interface BooksStatistic {
    int averagePublicationYear(Map<BookSignature, Book> books);
    int medianPublicationYear(Map<BookSignature, Book> books);
}
