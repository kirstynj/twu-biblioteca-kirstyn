package com.twu.biblioteca;

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
        System.out.println("\n Make a selection");
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

    public static void useInput2(int userInput){
        //if its an invalid option
        if (userInput < 1 || userInput > 2){
            String invalidNumberMessage;
            invalidNumberMessage = "Please select a valid option!\n";
            System.out.println(invalidNumberMessage);
        }
        else {
            performAction2(userInput);
        }
    }

    //perform the action
    public static void performAction(int userInput){
        if (userInput == 1){
            BookList.displayList();
            //option to select checkout or return
            printMenu2();
            useInput2(getInput());
        }
        else if (userInput == 0){
            quit = true;
        }
    }

    public static void performAction2(int userInput){
        if( userInput == 1){
            System.out.println("\n Choose a book to check-out");
            CheckOut.checkOutBook(getBookInput(), BookList.getBookList());
        }
        else if (userInput == 2){
            System.out.println("\n Chose a book to return");
            ReturnBook.ReturnBook(getBookInput(), CheckOut.getCheckedOut());
        }
    }

    private static String getBookInput(){
        //scanner to get book for checkout
        Scanner scanner = new Scanner(System.in);
        String userInput;
        userInput = scanner.nextLine();
        return userInput;
    }

    private static void printMenu2(){
        System.out.println("\n1) check-out a book!");
        System.out.println("2) return a book!");
    }
}
