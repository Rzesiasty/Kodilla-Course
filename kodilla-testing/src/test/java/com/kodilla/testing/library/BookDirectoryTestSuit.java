package com.kodilla.testing.library;

import javafx.beans.binding.When;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class BookDirectoryTestSuit {

    private List<Book> generateListOfNBooks(int booksQantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 0; n < booksQantity; n++) {
            Book book = new Book("book title" + n, "book author" + n, 2000 + n);
            resultList.add(book);
        }
        return resultList;
    }

    @Test
    public void testListBookWithConditionsReturnList() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBook = new ArrayList<>();
        Book book1 = new Book("title 1", "Author 1", 2005);
        Book book2 = new Book("title 2", "author 2", 2007);
        Book book3 = new Book("title 3", "author 3", 2007);
        resultListOfBook.add(book1);
        resultListOfBook.add(book2);
        resultListOfBook.add(book3);
        when(libraryDatabaseMock.listBookWithCondition("title")).thenReturn(resultListOfBook);

        //When
        List<Book> theListOfBook = bookLibrary.listBookWithCondition("title");

        //Then
        assertEquals(3, theListOfBook.size());
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBookWithCondition(anyString()))
                .thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBookWithCondition("ZeroBooks"))
                .thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBookWithCondition("FortyBooks"))
                .thenReturn(resultListOf40Books);

        // When
        List<Book> theListOfBooks0 = bookLibrary.listBookWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBookWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBookWithCondition("FortyBooks");
        // Then

        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    public void testListBookWithConditionFragmentShorterThan3() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf10Books = generateListOfNBooks(10);
        when(libraryDatabaseMock.listBookWithCondition(anyString())).thenReturn(resultListOf10Books);

        //When
        List<Book> listOf10Books = bookLibrary.listBookWithCondition("An");

        //Then
        assertEquals(0, listOf10Books.size());
        verify(libraryDatabaseMock, times(0)).listBookWithCondition(anyString());
    }
    @Test
    public void testListBooksInHandsOfWith0BooksBorrowed(){
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = generateListOfNBooks(0);
        LibraryUser libraryUser = new LibraryUser("First Name", "Last Name", "PESELID");
        when(libraryDatabaseMock.listBooksWithHandsOf(libraryUser)).thenReturn(resultListOf0Books);

        //When
        List<Book> listOf0Books = bookLibrary.listBooksInHandsOf(libraryUser);

        //Then
        assertEquals(resultListOf0Books.size(), listOf0Books.size());

    }
    @Test
    public void testListBooksInHandsOfWith1BookBorrowed(){
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultLisOf1Book = generateListOfNBooks(1);
        LibraryUser libraryUser = new LibraryUser("First Name", "Last Name", "PESELID");
        when(libraryDatabaseMock.listBooksWithHandsOf(libraryUser)).thenReturn(resultLisOf1Book);

        //When
        List<Book> listOf1Book = bookLibrary.listBooksInHandsOf(libraryUser);

        //Then
        assertEquals(resultLisOf1Book.size(), listOf1Book.size());
    }
    @Test
    public void testListBooksInHandsOfWith5BookBorrowed() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultLisOf5Books = generateListOfNBooks(5);
        LibraryUser libraryUser = new LibraryUser("First Name", "Last Name", "PESELID");

        when(libraryDatabaseMock.listBooksWithHandsOf(libraryUser)).thenReturn(resultLisOf5Books);

        //When
        List<Book> listOf5Books = bookLibrary.listBooksInHandsOf(libraryUser);

        //Then
        assertEquals(resultLisOf5Books.size(), listOf5Books.size());
    }
}
