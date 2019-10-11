package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ReturnBookTest {
    //test to see if once returned it goes back into the booklist
    @Test
    public void shouldReturnBookToBooklist(){
        //if its changing the something from here how to do i test that

    }

    @Test
    public void shouldReturnBookReturnSuccessMessage(){
        String expectedMessage = "Thank you for returning the book";

        ArrayList<Book> testBookList = new ArrayList<Book>();
        testBookList.add(new Book("title1", "author1", "1991"));
        testBookList.add(new Book("title2", "author2", "1992"));

        assertEquals(expectedMessage, ReturnBook.ReturnBook("title2", testBookList));

    }

    @Test
    public void shouldReturnBookReturnFailMessage(){
        String expectedMessage = "That is not a valid book to return";

        ArrayList<Book> testBookList = new ArrayList<Book>();
        testBookList.add(new Book("title1", "author1", "1991"));
        testBookList.add(new Book("title2", "author2", "1992"));

        assertEquals(expectedMessage, ReturnBook.ReturnBook("title3", testBookList));
    }

}