package com.twu.biblioteca;

import java.util.ArrayList;

public class UserList {
    private static ArrayList<User> users = new ArrayList<User>();

    public static void UserList(){
        users.add(new User("123-1234", "1234", "Kirstyn Jozefowski", "email.com", new PhoneNumber("0412345678")));
        users.add(new User("321-4321", "4321", "Susie Richards", "email.com", new PhoneNumber("0412345678")));
        users.add(new User("567-5678", "5678", "Carly Ramsay", "email.com", new PhoneNumber("0412345678")));
        users.add(new User("765-8765", "8765", "Dana Willow", "email.com", new PhoneNumber("0412345678")));
    }
    //new Username("123-1234")

    public static ArrayList<User> getUsers(){
        return users;
    }

    public static User findUser(String username){
        UserList();
        int i = 0;

        while (i < users.size()){
            if (users.get(i).getUsername().equals(username)){

                try{
                    User current = new User(users.get(i).getUsername(), users.get(i).getPassword(), users.get(i).getName(), users.get(i).getEmail(), users.get(i).getNumber());
                    System.out.println("set the current user");
                    return current;
                } catch(IllegalArgumentException e){
                    System.out.println("username incorrect format");
                }
            }
            i++;
        }
        //write a test here
        return null;

    }
}
