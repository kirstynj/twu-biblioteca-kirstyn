package com.twu.biblioteca;

import java.util.ArrayList;

public class UserList {
    private static ArrayList<User> users = new ArrayList<User>();

    public static void UserList(){
        users.add(new User("kirstynj", "1234", "Kirstyn Jozefowski", "email.com"));
        users.add(new User("susier", "4321", "Susie Richards", "email.com"));
        users.add(new User("carlyr", "5678", "Carly Ramsay", "email.com"));
        users.add(new User("danaw", "8765", "Dana Willow", "email.com"));
    }

    public static ArrayList<User> getUsers(){
        return users;
    }
    public static User findUser(String username){
        int i = 0;
        User current = null;
        while (i < users.size()){
            if (users.get(i).getUsername().equals(username)){
                current = users.get(i);
            }
        }
        return current;

    }
}
