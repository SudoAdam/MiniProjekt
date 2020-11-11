package com.example.demo.domain;

public class Message {

    int senderID;
    int recieverID;
    String message;

    public Message(int senderID, int recieverID, String message) {
        this.senderID = senderID;
        this.recieverID = recieverID;
        this.message = message;
    }
}
