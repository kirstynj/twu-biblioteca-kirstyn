package com.twu.biblioteca;

import java.util.ArrayList;

public class ReturnBook {

    public static void ReturnBook(String input, ArrayList<Book> checkedOutList){
        boolean contains = false;
        int i =0;
        while (i< checkedOutList.size()){
            if (checkedOutList.get(i).getTitle().equals(input)){
                System.out.println("Thank you for returning the book");
                //add back to booklist
                BookList.getBookList().add(checkedOutList.get(i));
                //remove book from checked out list
                checkedOutList.remove(i);
                contains = true;
                break;
            }
            i++;
        }
        if (!contains){
            System.out.println("That is not a valid book to return");
        }

    }
}
