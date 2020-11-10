package com.example.demo.database;

import com.example.demo.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBSeach {

    public void seach(String seachStatement) {
        Connection connection = DBManager.getConnection();
        String id = "" + User.getId();

        String searchStr = "SELECT count(*) FROM users ? except where id ='?';";
        PreparedStatement preparedStatement;
        int res = -1;
        ResultSet resset;
        try {
            preparedStatement = connection.prepareStatement(searchStr);
            preparedStatement.setString(1, seachStatement);
            preparedStatement.setString(2, id );
            System.out.println(searchStr);
            System.out.println(preparedStatement);
            resset = preparedStatement.executeQuery();
            if (resset.next()) {
                String str = "" + resset.getObject(1);
                res = Integer.parseInt(str);
                System.out.println("fundet antal = " + res);
            }

        } catch (
                SQLException sqlerr) {
            System.out.println("fejl i søgning = " + sqlerr.getMessage());
        }
    }
}
