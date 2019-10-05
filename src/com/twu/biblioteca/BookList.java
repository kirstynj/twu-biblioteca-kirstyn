package com.twu.biblioteca;

import java.util.*;

public class BookList {

    public static void displayList(ArrayList<Book> list){
        int i=0;
        while (i < list.size()){

            System.out.println(list.get(i).toString());
            i++;
        }
    }

}
