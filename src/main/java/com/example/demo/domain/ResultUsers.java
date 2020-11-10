package com.example.demo.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ResultUsers {

    private int id;
    private String username;
    private String name;
    private String surname;
    private String region;
    private int age;
    private String about;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;



    public ResultUsers(int id, String username, String name, String surname, String region, int age, String about) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.region = region;
        this.age = age;
        this.about = about;
        // this.date = date;
    }

    @Override
    public String toString() {
        return "ResultUsers{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", region='" + region + '\'' +
                ", age=" + age +
                ", about='" + about + '\'' +
                '}';
    }
}
