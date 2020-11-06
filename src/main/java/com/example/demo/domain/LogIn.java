package com.example.demo.domain;

import com.example.demo.database.DBManager;
import com.example.demo.database.JDBCWriter;

import java.sql.Connection;

public class LogIn {

    JDBCWriter jdbcWriter = new JDBCWriter();


   /* public boolean userExsist(String user) {
        Boolean exsist = false;

        if (Database.findUser(user) == 1)
            exsist = true;
        return exsist;
    }*/

    public User login(String username, String password) {
        Connection connection = DBManager.getConnection();
        int id = jdbcWriter.logIn(username, password);
        if (id != -1) {
            User user = new User(id, username, password);
            System.out.println(user);
            return user;
        } else {
            User user = new User();
            return user;
        }
    }

    public void create(String username, String password) {

    }
}
