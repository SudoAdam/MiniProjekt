package com.example.demo.database;

import com.example.demo.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBSearch {

    public void search(String seachStatement) {
        Connection connection = DBManager.getConnection();
        String id = "" + User.getId();

        String searchStr = "SELECT username, age FROM users where ? not user_id = ?";
        // select username from users where not user_id ='13'
        PreparedStatement preparedStatement;
        int res = -1;
        ResultSet resset;
        try {
            preparedStatement = connection.prepareStatement(searchStr);
            preparedStatement.setString(1, seachStatement);
            preparedStatement.setString(2, id);
            System.out.println(searchStr);
            System.out.println(preparedStatement);
            resset = preparedStatement.executeQuery();
            String resSTR = "";
            int i = 0;
            while (resset.next()) {
                i++;
                resSTR += resset.getObject(1) + ", ";
                resSTR += resset.getObject(2) + "\n";
                //res = Integer.parseInt(str);
            }
            System.out.println("fundet  = " + resSTR);

        } catch (
                SQLException sqlerr) {
            System.out.println("fejl i søgning = " + sqlerr.getMessage());
        }
    }
}
