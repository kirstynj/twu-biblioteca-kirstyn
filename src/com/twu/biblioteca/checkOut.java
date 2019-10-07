package com.twu.biblioteca;

import java.util.ArrayList;

public class checkOut {

    private static ArrayList<Book> checkedOut = new ArrayList<Book>();

    public static void checkOut(String input, ArrayList<Book> list){
        //get the input string, search the arraylist of books - title for a match
        //then remove the book from the list and add it to the new list checkedOut
        boolean contains = false;
        int i =0;
        while (i< list.size()){
            if (list.get(i).getTitle().equals(input)){
                System.out.println("Thank you! Enjoy the book");
                //add to new list
                checkedOut.add(list.get(i));
                //remove book from list
                list.remove(i);
                contains = true;
                break;
            }
            i++;
        }
        if (!contains){
            System.out.println("Sorry, that book is not available");
        }
    }

    public static ArrayList<Book> getCheckedOut(){
        return checkedOut;
    }
}
