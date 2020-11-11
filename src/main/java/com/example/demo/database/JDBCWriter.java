package com.example.demo.database;

import com.example.demo.domain.User;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Vector;

public class JDBCWriter {

    // private static Connection connection = null;

   /* public boolean setConnection() {
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
    }*/

   /* public Vector<String> getLines(String aURL, String aWord) {
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
    }*/


    public String getUser(int id) {
        Connection connection = DBManager.getConnection();
        String seachStr = "SELECT * FROM users where user_id = ? ";
        PreparedStatement preparedStatement;
        String bruger = "";
        try {
            preparedStatement = connection.prepareStatement(seachStr);
            preparedStatement.setString(1, "%" + id + "%");
            System.out.println(seachStr);
            ResultSet resset = preparedStatement.executeQuery();
            while (resset.next()) {
                String str1 = "" + resset.getObject(1);
                bruger += str1;
            }
        } catch (SQLException sqlerr) {
            System.out.println("Error in select = " + sqlerr.getMessage());
        }
        return bruger;
    }

    public void createUser(User u) {
        Connection connection = DBManager.getConnection();
        String sqlstr = "INSERT INTO users (username, password, name, surname, region, age, about) VAlUES (?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sqlstr);
            preparedStatement.setString(1, u.getUsername());
            preparedStatement.setString(2, u.getPassword());
            preparedStatement.setString(3, u.getName());
            preparedStatement.setString(4, u.getSurname());
            preparedStatement.setString(5, u.getRegion());
            preparedStatement.setInt(6, u.getAge());
            preparedStatement.setString(7, u.getAbout());
            int row = preparedStatement.executeUpdate();
            System.out.println(row);
            System.out.println(preparedStatement);
        } catch (SQLException sqlerr) {
            System.out.println("Fejl i oprettels=" + sqlerr);
        }
    }

    public void updateUser(User u) {
        Connection connection = DBManager.getConnection();
        String sqlupstr = "UPDATE users SET(username, password, name, surname, region, age, about, date_for_test) VAlUES (?, ?, ?, ?, ?, ?, ?, ?) WHERE user_id = u;";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sqlupstr);
            preparedStatement.setString(1, u.getUsername());
            preparedStatement.setString(2, u.getPassword());
            preparedStatement.setString(3, u.getName());
            preparedStatement.setString(4, u.getSurname());
            preparedStatement.setString(5, u.getRegion());
            preparedStatement.setInt(6, u.getAge());
            preparedStatement.setString(7, u.getAbout());
        } catch (SQLException sqlerr) {
            System.out.println("Fejl i opdatering" + sqlerr);
        }
    }

    public void removeUser(int userID){
        Connection connection = DBManager.getConnection();
        String sqlRemove = "DELETE * FROM users WHERE user_id = ?";
        PreparedStatement preparedStatement;
        String userIDstr = "" + userID;
        try{
            preparedStatement = connection.prepareStatement(sqlRemove);
            preparedStatement.setString(1,   userIDstr );
            preparedStatement.execute(sqlRemove);
        } catch(SQLException sqlerr){
            System.out.println("Fejl =" + sqlerr);
        }
    }

    public User logIn(String user, String pass) {
        Connection connection = DBManager.getConnection();
        String searchStr = "SELECT count(*) as user_id, username, age , name, surname, region, about, is_admin FROM users where username = ? and password = ? ;";
        PreparedStatement preparedStatement;
        User u = new User();
        int res = -1;
        ResultSet resset;
        try {
            preparedStatement = connection.prepareStatement(searchStr);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);
            System.out.println(searchStr);
            System.out.println(preparedStatement);
            resset = preparedStatement.executeQuery();
            if (resset.next()) {
                String str = "" + resset.getObject(1);
                res = Integer.parseInt(str);
                System.out.println("fundet antal = " + res);
            }
            if (res == 1) {
                String id = "" + resset.getObject("user_id");
                String username = "" + resset.getObject("username");
                String age = "" + resset.getObject("age");
                String name = "" + resset.getObject("name");
                String surname = "" + resset.getObject("surname");
                String region = "" + resset.getObject("region");
                String about = "" + resset.getObject("about");
                String is_admin = "" + resset.getObject("is_admin");

                int idN = Integer.parseInt(id);
                int ageN = Integer.parseInt(age);
                Boolean isAdmin = false;

                if (is_admin.equals("1")){
                    isAdmin = true;
                }
                u = new User(idN, username,pass,name,surname,region, ageN,about,isAdmin);
            } else {
                System.out.println("login fejl. antal fundne profiler: " + res);
            }

        } catch (SQLException sqlerr) {
            System.out.println("fejl i søgning = " + sqlerr.getMessage());
        }

        return u;
    }

    public Boolean userExist(int id) {
        Connection connection = DBManager.getConnection();
        String searchStr = "SELECT count(*) FROM users where user_id = ?";
        PreparedStatement preparedStatement;
        int res = -1;
        String idStr = "" + id;
        ResultSet resset;
        Boolean exist = false;
        try {
            preparedStatement = connection.prepareStatement(searchStr);
            preparedStatement.setString(1, idStr);
            System.out.println(searchStr);
            System.out.println(preparedStatement);
            resset = preparedStatement.executeQuery();
            if (resset.next()) {
                String str = "" + resset.getObject(1);
                res = Integer.parseInt(str);
                System.out.println("fundet antal = " + res);
            }
            if (res == 1) {
                exist = true;
            } else {
                System.out.println("fejl. antal fundne profiler: " + res);
            }

        } catch (SQLException sqlerr) {
            System.out.println("fejl i exist = " + sqlerr.getMessage());
        }

        return exist;
    }



/*    public int deleteRows(String aURL, String aWord) {
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
    }*/

   /* public int writeLines(String aUlr, ArrayList<String> aLst) {
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
    }*/

}
