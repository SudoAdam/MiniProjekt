package com.example.demo.services;

import com.example.demo.database.DBManager;
import com.example.demo.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Service {

    public int addUser(String aUserAdd, ArrayList<String> aLst){
        Connection connection = DBManager.getConnection();
        String sql = "INSERT INTO users (username, password, name, surname, region, age, about, date_for_test) VAlUES (?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement;
        int res = 0;
        for (String str: aLst){
            try{
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, aUserAdd);
                int rowcount = preparedStatement.executeUpdate();
                System.out.println("Indsat række=" +rowcount);
                res = res + rowcount;
            } catch (SQLException sqlerr){
                System.out.println("Fejl i Insert" + sqlerr.getMessage());
            }
        }
        return res;
    }
}
