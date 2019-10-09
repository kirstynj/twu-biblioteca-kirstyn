package com.twu.biblioteca;

public class Username {
    private String usernameString;

    public Username(String username) throws IllegalArgumentException{
        int length = username.length();
        String firstThree;
        String lastFour;
        if (length == 8){

            firstThree = username.substring(0, 4);
            lastFour = username.substring(4, 8);
            for (int i=0; i<3; i++){
                if (!(Character.isDigit(firstThree.charAt(i)))) {
                    throw new IllegalArgumentException();
                }
            }
            if (!(username.charAt(3) == '-')){
                throw new IllegalArgumentException();
            }
            for (int i=0; i<4; i++){
                if (!(Character.isDigit(lastFour.charAt(i)))) {
                    throw new IllegalArgumentException();
                }
            }
            this.usernameString = username;


        } else{
            throw new IllegalArgumentException();
        }
    }

    public String getUsernameString(){
        return usernameString;
    }
}
