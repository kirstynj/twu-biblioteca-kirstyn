package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTest {

    @Test
    public void shouldReturnMenu(){
        String expectedMenu = "\n Make a selection \n 1) List of books \n 0) Quit";
        assertEquals(expectedMenu, Menu.getMenu());
    }

   // @Test (expected = NumberFormatException.class)

//    @Test
//    public void TestInvalidNumber(){
//        //given the number entered is invalid
//        int enteredNumber = 3;
//  i cant get this to work
//        //when the  method is called
//        Menu.useInput(enteredNumber);
//
//        //then assert that the error message is shown
//        String expectedMessage = "Invalid number, please choose from the options below \n";
//        assertThat(expectedMessage, is ...)
 //   }

    @Test
    public void TestIfExit(){
        //given number entered is 0
        int enteredNumber = 0;
        //when method is called
        Menu.performAction(enteredNumber);

        //then assert boolean for quit is true
        assertTrue(Menu.quit);
    }


}