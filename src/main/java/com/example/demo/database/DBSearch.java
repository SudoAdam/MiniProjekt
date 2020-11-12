package com.example.demo.database;

import com.example.demo.domain.ResultUsers;
import com.example.demo.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBSearch {

    public ArrayList<ResultUsers> search(String seachStatement, User u) {
        Connection connection = DBManager.getConnection();
        String id = "" + u.getId();
        ArrayList<ResultUsers> result = new ArrayList<>();

        String searchStr = "SELECT user_id, username, age , name, surname, region, about FROM users where ";
        searchStr += seachStatement;
        searchStr += " not user_id = ?"; // and not is_admin = '1'
        // select username from users where not user_id ='13'
        PreparedStatement preparedStatement;
        int res = -1;
        ResultSet resset;
        try {
            preparedStatement = connection.prepareStatement(searchStr);
           // preparedStatement.setString(1, seachStatement);
            preparedStatement.setString(1, id);
            System.out.println(searchStr);
            System.out.println(preparedStatement);
            resset = preparedStatement.executeQuery();
            String resSTR = "";
            while (resset.next()) {
                resSTR += resset.getObject(1) + ", ";
                resSTR += resset.getObject(2) + ", ";
                resSTR += resset.getObject(3) + ", ";
                resSTR += resset.getObject(4) + ", ";
                resSTR += resset.getObject(5) + ", ";
                resSTR += resset.getObject(6) + ", ";
                resSTR += resset.getObject(7) + "\n";

                //user_id, username, age , name, surname, region, about
                String resultID = "" + resset.getObject(1);
                String resultUsername = ""+resset.getObject(2);
                String resultAge = ""+ resset.getObject(3);
                String resultName = ""+ resset.getObject(4);
                String resultSurname = ""+ resset.getObject(5);
                String resultRegion = ""+ resset.getObject(6);
                String resultAbout = ""+ resset.getObject(7);

                System.out.println(resultID);
                int resultIntId = Integer.parseInt(resultID);
                System.out.println(resultIntId);
                int resultIntAge =  Integer.parseInt(resultAge);
                ResultUsers user = new ResultUsers(resultIntId, resultUsername, resultName, resultSurname,
                                        resultRegion, resultIntAge, resultAbout);
                System.out.println(user);
                result.add(user);
                //res = Integer.parseInt(str);
            }
            System.out.println("fundet  = " + resSTR);

        } catch (
                SQLException sqlerr) {
            System.out.println("fejl i søgning = " + sqlerr.getMessage());
        }
        System.out.println(result);
        return result;
    }
}
