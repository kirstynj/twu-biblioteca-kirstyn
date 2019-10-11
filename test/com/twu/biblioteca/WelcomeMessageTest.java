package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class WelcomeMessageTest {

    @Test
    public void shouldReturnWelcomeMessage(){
        String expectedWelcomeMessage = "Welcome to Biblioteca! \n Your one-stop-shop for great book titles in Bangalore";
        assertEquals(expectedWelcomeMessage, WelcomeMessage.getWelcomeMessage());
    }
}