package com.twu.biblioteca;

import java.util.*;


public class BookList {

    private static ArrayList<Book> bookList= new ArrayList<Book>();


    public void BookList(){
        bookList.add(new Book("title1", "author1", "1991"));
        bookList.add(new Book("title2", "author2", "1992"));
        bookList.add(new Book("title3", "author3", "1993"));
    }

    public static ArrayList<Book> getBookList(){
        return bookList;
    }

    public static void displayList(){
        int i=0;
        while (i < bookList.size()){
            System.out.println(bookList.get(i).toString());
            i++;
        }
    }

//    public static void createTable(Jtable table){
//
//        for (int i=0; i<bookList.size(); i++){
//            String title = bookList.get(i).getTitle();
//            String author = bookList.get(i).getAuthor();
//            String year = bookList.get(i).getYear();
//
//            Object[] data = {title, author, year};
//
//            table.add(data);
//        }
//    }


}
