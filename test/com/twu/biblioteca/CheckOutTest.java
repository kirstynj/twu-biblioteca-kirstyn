package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.*;

public class CheckOutTest {

    @Test
    public void testCheckOut() {
        Book book1 = new Book("title1", "author1", "1991");
        Book book2 = new Book("title2", "author2", "1992");
        Book book3 = new Book("title3", "author3", "1993");

        //test list with title3 missing
        ArrayList<Book> testList = new ArrayList<Book>();
        testList.add(book1);
        testList.add(book2);

        ArrayList<Book> list = new ArrayList<Book>();
        list.add(book1);
        list.add(book2);
        list.add(book3);

        CheckOut.checkOutBook("title3", list);

        assertEquals(testList, list);
    }

    @Test
    public void shouldReturnBookSuccessMessage(){
        String expectedMessage = "Thank you! Enjoy the book";

        ArrayList<Book> testBookList = new ArrayList<Book>();
        testBookList.add(new Book("title1", "author1", "1991"));
        testBookList.add(new Book("title2", "author2", "1992"));
        testBookList.add(new Book("title3", "author3", "1993"));

        assertEquals(expectedMessage, CheckOut.checkOutBook("title2", testBookList));

    }
    @Test
    public void shouldReturnBookFailMessage(){
        String expectedMessage = "Sorry, that book is not available";

        ArrayList<Book> testBookList = new ArrayList<Book>();
        testBookList.add(new Book("title1", "author1", "1991"));
        testBookList.add(new Book("title2", "author2", "1992"));
        testBookList.add(new Book("title3", "author3", "1993"));

        assertEquals(expectedMessage, CheckOut.checkOutBook("title", testBookList));
    }
}