package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    static boolean  quit;


    //run menu
    public static void menu(){
        while(!quit){
            printMenu();
            int userInput = getInput();
            useInput(userInput);
        }
    }
    //print menu
    private static void printMenu(){
        System.out.println("Make a selection");
        System.out.println("1) List of books");
        System.out.println("0) Quit");
    }

    //get user input
    private static int getInput(){
        //scanner to get menu selection
        Scanner scanner = new Scanner(System.in);
        int userInput = -1;
            try {
                System.out.println("\n Enter your choice: ");
                userInput = Integer.parseInt(scanner.nextLine());
            }
            catch(NumberFormatException e) {
                System.out.println("Please select a valid option! \n");
                menu();
            }
        return userInput;
    }

    public static void useInput(int userInput){
        //if its an invalid option
        if (userInput < 0 || userInput > 1){
            String invalidNumberMessage;
            invalidNumberMessage = "Please select a valid option!\n";
            System.out.println(invalidNumberMessage);
            menu();
        }
        else {
            performAction(userInput);
        }
    }

    //perform the action
    public static void performAction(int userInput){
        if (userInput == 1){
            ArrayList<Book> list = new ArrayList<Book>();
            //add random books to list
            list.add(new Book("title1", "author1", "1991"));
            list.add(new Book("title2", "author2", "1992"));
            list.add(new Book("title3", "author3", "1993"));

            BookList.displayList(list);
        }
        else if (userInput == 0){
            quit = true;
        }
    }
}
