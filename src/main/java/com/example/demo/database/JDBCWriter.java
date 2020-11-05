package com.example.demo.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class JDBCWriter {

    private Connection connection = null;

    public boolean setConnection() {
        final String url = "jdbc:mysql://localhost:3306/userdb?serverTimezone=UTC";
        boolean bres = false;
        try {
            connection = DriverManager.getConnection(url, "root", "Computerlastbil1");
            bres = true;
            System.out.println("connection SUCSSES");
        } catch (SQLException ioerr) {
            System.out.println("Vi fik IKKE connection=" + ioerr.getMessage());
        }
        return bres;
    }

    public Vector<String> getLines(String aURL, String aWord) {
        String seachStr = "SELECT left(line,50) as line FROM urlreads where url like ? and line like ? LIMIT 20";
        PreparedStatement preparedStatement;
        Vector<String> v1 = new Vector<>();
        try {
            preparedStatement = connection.prepareStatement(seachStr);
            preparedStatement.setString(1, "%" + aURL + "%");
            preparedStatement.setString(2, "%" + aWord + "%");
            System.out.println(seachStr);
            ResultSet resset = preparedStatement.executeQuery();
            while (resset.next()) {
                String str1 = "" + resset.getObject("line");
                v1.add(str1);
            }
        } catch (SQLException sqlerr) {
            System.out.println("Error in select = " + sqlerr.getMessage());
        }
        return v1;
    }

    public int logIn(String user, String pass) {
        String searchStr = "SELECT count(*) as line, user_id FROM users where username = ? and password = ?";
        PreparedStatement preparedStatement;
        int res = -1;
        int id = -1;
        ResultSet resset = null;
        try {
            preparedStatement = connection.prepareStatement(searchStr);
            preparedStatement.setString(1, "%" + user + "%");
            preparedStatement.setString(2, "%" + pass + "%");
            System.out.println(searchStr);
            resset = preparedStatement.executeQuery();
            if (resset.next()) {
                String str = "" + resset.getObject(1);
                res = Integer.parseInt(str);
                System.out.println("fundet antal = " + res);
            }
            if (res == 1) {
                String idOBJ = "" + resset.getObject("user_id");
                id = Integer.parseInt(idOBJ);
            } else {
                System.out.println("login fejl. antal fundne profiler: " + res);
            }

        } catch (SQLException sqlerr) {
            System.out.println("fejl i søgning = " + sqlerr.getMessage());
        }

        return id;
    }

    public int deleteRows(String aURL, String aWord) {
        String delStr = "DELETE FROM urlreads where url like ? and line like ?";
        PreparedStatement preparedStatement;
        int res = -1;
        try {
            preparedStatement = connection.prepareStatement(delStr);
            preparedStatement.setString(1, "%" + aURL + "%");
            preparedStatement.setString(2, "%" + aWord + "%");
            res = preparedStatement.executeUpdate();
        } catch (SQLException sqlerr) {
            System.out.println("Error in delete =" + sqlerr.getMessage());
        }
        return res;
    }

    public int writeLines(String aUlr, ArrayList<String> aLst) {
        String insstr = "INSERT INTO urlreads(url, line, linelen, medtext) values (?, ?, ?, ?)";
        PreparedStatement preparedStatement;
        int res = 0;
        String lineln = "";
        for (String line : aLst) {
            try {
                preparedStatement = connection.prepareStatement(insstr);
                preparedStatement.setString(1, aUlr);
                lineln = "" + line.length();
                if (line.length() < 15000) {
                    preparedStatement.setString(2, line);
                    preparedStatement.setString(3, "" + lineln);
                    preparedStatement.setString(4, " ");
                } else {
                    preparedStatement.setString(2, " ");
                    preparedStatement.setString(3, "" + lineln);
                    preparedStatement.setString(4, line);
                }
                int rowcount = preparedStatement.executeUpdate();
                //System.out.println("Indsat række=" + rowcount);
                res = res + rowcount;
                if (res % 100 == 0) {
                    System.out.println("Har saved rowcount=" + res);
                }
            } catch (SQLException sqlerr) {
                String errmsg = sqlerr.getMessage();
                System.out.println("Fejl i INSERT=" + errmsg + " len=" + lineln);
            }
        }
        return res;
    }

}
