package com.twu.biblioteca;

import java.util.ArrayList;

public class Login {

    public static boolean Login(String username, String password, ArrayList<User> users){
        int i = 0;
        while (i < users.size()){
            if (users.get(i).getUsername().equals(username)){
                if (users.get(i).getPassword().equals(password)){
                    //correct credentials
                    return true;
                }
            }
            i++;
        }
        return false;
    }

}
