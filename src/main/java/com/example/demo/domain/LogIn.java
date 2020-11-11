package com.example.demo.domain;

import com.example.demo.database.JDBCWriter;

public class LogIn {

    JDBCWriter jdbcWriter = new JDBCWriter();


   /* public boolean userExsist(String user) {
        Boolean exsist = false;

        if (Database.findUser(user) == 1)
            exsist = true;
        return exsist;
    }*/

    public User login(String username, String password) {
        User user = jdbcWriter.logIn(username, password);
        System.out.println(user);
        return user;
    }

    public void create(String username, String password) {
    }

    public void logout() {
        User user = new User();
        System.out.println(user);
    }
}
