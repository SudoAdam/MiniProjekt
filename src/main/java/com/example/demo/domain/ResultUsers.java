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
    private String imageLink;




    public ResultUsers(int id, String username, String name, String surname, String region, int age, String about, String imageLink) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.region = region;
        this.age = age;
        this.about = about;
        // this.date = date;
        this.imageLink = imageLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
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
                ", date=" + date +
                ", imageLink='" + imageLink + '\'' +
                '}';
    }
}
