package com.example.demo.user;

public class LogIn {


    public boolean userExsist (String user){
        Boolean exsist = false;
        return exsist;
    }

    public User login (String username, String password){
      User user = new User(1, username, password);
      return user;
    }
    public void create (String username, String password){

    }
}
