package com.twu.biblioteca;

public class User {
    private String username;
    private String password;
    private String name;
    private String email;
    private PhoneNumber number;

    public User(String username, String password, String name, String email, PhoneNumber number) throws IllegalArgumentException {
        if (usernameFormatCorrect(username)){
            this.username = username;
        }else{
            throw new IllegalArgumentException();
        }
        this.password = password;
        this.name = name;
        this.email = email;
        this.number = number;
    }

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public PhoneNumber getNumber(){
        return number;
    }

    public boolean usernameFormatCorrect(String username){
        int length = username.length();
        String firstThree;
        String lastFour;
        if (length == 8){

            firstThree = username.substring(0, 4);
            lastFour = username.substring(4, 8);
            for (int i=0; i<3; i++){
                if (!(Character.isDigit(firstThree.charAt(i)))) {
                    return false;
                }
            }
            if (!(username.charAt(3) == '-')){
                return false;
            }
            for (int i=0; i<4; i++){
                if (!(Character.isDigit(lastFour.charAt(i)))) {
                    return false;
                }
            }
            return true;
        } else{
            return false;
        }
    }
}

