package com.example.demo.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {
    private static int id = -1;
    private String username;
    private String password; // til intern test
    private String name;
    private String surname;
    private String region;
    private int age;
    private String about;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User(String username, String password, String name, String surname, String region, int age, String about) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.region = region;
        this.age = age;
        this.about = about;
        // this.date = date;
    }

    public User(int id, String username, String name, String surname, String region, int age, String about) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.region = region;
        this.age = age;
        this.about = about;
        // this.date = date;
    }

    public User(){
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
