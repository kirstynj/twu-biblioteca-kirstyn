package com.twu.biblioteca;

public class WelcomeMessage {

    public void printWelcomeMessage(){
        System.out.println("+---------------------------------------------------------+");
        System.out.println("|                Welcome to Biblioteca!                   |");
        System.out.println("|  Your one-stop-shop for great book titles in Bangalore  |");
        System.out.println("+---------------------------------------------------------+");
    }

    public static String getWelcomeMessage(){
        String message ="Welcome to Biblioteca! \n Your one-stop-shop for great book titles in Bangalore";
        return message;
    }
}
