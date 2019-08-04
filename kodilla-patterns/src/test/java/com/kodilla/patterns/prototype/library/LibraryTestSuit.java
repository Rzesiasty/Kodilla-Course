package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuit {

    @Test
    public void testGetBooks(){
        //Given
        Library library = new Library("Library 1");
        library.getBooks().add(new Book("Train", "Steven Harold", LocalDate.parse("2019-05-04")));
        library.getBooks().add(new Book("Komite-Komitsu", "Hiroki Hatsu", LocalDate.parse("1987-09-05")));
        library.getBooks().add(new Book("North Carolina", "Daniel McGregor", LocalDate.parse("1896-12-25")));

        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Library 2");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Library 3");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        //When
        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);
        //Then
        Assert.assertEquals(3, library.getBooks().size());
        Assert.assertEquals(3, clonedLibrary.getBooks().size());
        Assert.assertEquals(3, deepClonedLibrary.getBooks().size());
        Assert.assertEquals(clonedLibrary.getBooks(), library.getBooks());
        Assert.assertNotEquals(deepClonedLibrary.getBooks(), library.getBooks());
    }
}
