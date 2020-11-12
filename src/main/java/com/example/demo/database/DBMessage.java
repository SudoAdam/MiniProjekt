package com.example.demo.database;

import com.example.demo.domain.Message;
import com.example.demo.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBMessage {
/*
    public ArrayList<Message> getMessage() {
        Connection connection = DBManager.getConnection();
        ArrayList<Message> messages = new ArrayList<>();
        String searchStr = "SELECT * as id_sender, message, id_reciever FROM message where id_reciever = ? ;";
        PreparedStatement preparedStatement;
        int res = -1;
        String id = "" + User.getId();
        ResultSet resset;
        try {
            preparedStatement = connection.prepareStatement(searchStr);
            preparedStatement.setString(1,id );
            System.out.println(searchStr);
            System.out.println(preparedStatement);
            resset = preparedStatement.executeQuery();
            if (resset.next()) {
                String str = "" + resset.getObject(1);
                res = Integer.parseInt(str);
                System.out.println("fundet antal = " + res);
            }
            while (resset.next()) {
                String IDsender = "" + resset.getObject("id_sender");
                String messageStr = "" + resset.getObject("Message");
                String IDreciever = "" + resset.getObject("id_reciever");

                int senderID = Integer.parseInt(IDsender);
                int recieverID = Integer.parseInt(IDreciever);

                Message message = new Message(senderID, recieverID, messageStr);
                messages.add(message);
            }

        } catch (SQLException sqlerr) {
            System.out.println("fejl i bedskeder = " + sqlerr.getMessage());
        }
            return messages;
    }*/
}
