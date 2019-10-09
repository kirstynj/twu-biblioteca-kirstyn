package com.twu.biblioteca;

public class PhoneNumber {
    private String number;

    public PhoneNumber(String number) throws IllegalArgumentException{
        int length = number.length();
        if (length ==  10){
            for (int i=0; i < 10; i++){
                if (!(Character.isDigit(number.charAt(i)))){
                    throw new IllegalArgumentException();
                }
            }
            this.number = number;

        } else{
            throw new IllegalArgumentException();
        }
    }

    public String getNumber(){
        return number;
    }
}
