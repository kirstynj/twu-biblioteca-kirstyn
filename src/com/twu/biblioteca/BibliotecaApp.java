package com.twu.biblioteca;

public class BibliotecaApp {

    public void run(){
        new WelcomeMessage().printWelcomeMessage();
        new BookList().BookList();
        Menu.menu();
    }

    public static void main(String[] args) {
        new BibliotecaApp().run();
    }

}
