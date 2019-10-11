package com.twu.biblioteca;

import java.util.ArrayList;

public class ReturnBook {

    public static String getBookReturnSuccessMessage(){
        return "Thank you for returning the book";
    }
    public static String getBookReturnFailMessage(){
        return "That is not a valid book to return";
    }

    public static String ReturnBook(String input, ArrayList<Book> checkedOutList){
        String returnMessage = null;
        boolean contains = false;
        int i =0;
        while (i< checkedOutList.size()){
            if (checkedOutList.get(i).getTitle().equals(input)){
                returnMessage = getBookReturnSuccessMessage();
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
            returnMessage = getBookReturnFailMessage();
        }
        return returnMessage;

    }
}
