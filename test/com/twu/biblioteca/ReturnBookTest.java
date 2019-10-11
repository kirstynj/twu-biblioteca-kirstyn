package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ReturnBookTest {
    //test to see if once returned it goes back into the booklist
    @Test
    public void shouldReturnBookToBooklist(){
        //books
        Book book1 = new Book("title1", "author1", "1991");
        Book book2 = new Book("title2", "author2", "1992");
        Book book3 = new Book("title3", "author3", "1993");


        //if its changing the something from here how to do i test that
        ArrayList<Book> testCheckedOutBooklist = new ArrayList<Book>();
        testCheckedOutBooklist.add(book1);
        testCheckedOutBooklist.add(book2);

        ArrayList<Book> testCurrentLibBooklist = new ArrayList<Book>();
        testCurrentLibBooklist.add(book3);

        ArrayList<Book> testExpected = new ArrayList<Book>();
        testExpected.add(book3);
        testExpected.add(book1);

        ReturnBook.ReturnBook("title1", testCheckedOutBooklist, testCurrentLibBooklist);

        assertEquals(testExpected, testCurrentLibBooklist);
    }

    @Test
    public void shouldReturnBookReturnSuccessMessage(){
        String expectedMessage = "Thank you for returning the book";

        ArrayList<Book> testBookList = new ArrayList<Book>();
        testBookList.add(new Book("title1", "author1", "1991"));
        testBookList.add(new Book("title2", "author2", "1992"));

        assertEquals(expectedMessage, ReturnBook.ReturnBook("title2", testBookList, BookList.getBookList()));

    }

    @Test
    public void shouldReturnBookReturnFailMessage(){
        String expectedMessage = "That is not a valid book to return";

        ArrayList<Book> testBookList = new ArrayList<Book>();
        testBookList.add(new Book("title1", "author1", "1991"));
        testBookList.add(new Book("title2", "author2", "1992"));

        assertEquals(expectedMessage, ReturnBook.ReturnBook("title3", testBookList, BookList.getBookList()));
    }

}