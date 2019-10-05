package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {

        WelcomeMessage.printWelcomeMessage();

        ArrayList<Book> list = new ArrayList<Book>();
        //add random books to list
        list.add(new Book("title1", "author1", "1991"));
        list.add(new Book("title2", "author2", "1992"));
        list.add(new Book("title3", "author3", "1993"));

        BookList.displayList(list);

    }

}
