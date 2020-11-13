package com.example.demo.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {
    private int id;
    private String username;
    private String password; // til intern test
    private String name;
    private String surname;
    private String region;
    private int age;
    private String about;
    private int gender_id;
    private Boolean isAdmin;
    private String imageLink;

   /* public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }*/

    public User( int id, String username, String password, String name, String surname, String region, int age, String about, Boolean isAdmin, int gender_id, String imageLink) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.region = region;
        this.age = age;
        this.about = about;
        this .isAdmin = isAdmin;
        this.gender_id = gender_id;
        this.imageLink = imageLink;
    }

    public User(String name, String surname, String region, int age, String about, Boolean isAdmin) {
        this.name = name;
        this.surname = surname;
        this.region = region;
        this.age = age;
        this.about = about;
        this .isAdmin = isAdmin;
    }

    public User(String username, String password, String name, String surname, String region, int age, String about, Boolean isAdmin, String imageLink,  int gender_id) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.region = region;
        this.age = age;
        this.about = about;
        this .isAdmin = isAdmin;
        this.gender_id = gender_id;
        this.imageLink = imageLink;
    }

    public User(){

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public int getGender_id() {
        return gender_id;
    }

    public void setGender_id(int gender_id) {
        this.gender_id = gender_id;
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
