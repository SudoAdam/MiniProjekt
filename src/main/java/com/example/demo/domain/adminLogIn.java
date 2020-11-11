package com.example.demo.domain;

import com.example.demo.database.JDBCWriter;

public class adminLogIn {

    JDBCWriter jdbcWriter = new JDBCWriter();


   /* public boolean userExsist(String user) {
        Boolean exsist = false;

        if (Database.findUser(user) == 1)
            exsist = true;
        return exsist;
    }*/
/*
    public User login(String username, String password, boolean isAdmin) {
        int id = jdbcWriter.logIn(username, password);
        if (id != -1 && isAdmin == true) {
            User user = new User(id, username, password);
            System.out.println(user);
            return user;
        } else {
            User user = new User();
            return user;
        }
    }*/
/*
    public void create(String username, String password) {
    }
    public void logout(){
        User user = new User(-1,"","");
    }*/
}
