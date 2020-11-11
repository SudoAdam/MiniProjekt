package com.example.demo.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {
    private static int id = -1;
    private static String username;
    private static String password; // til intern test
    private static String name;
    private static String surname;
    private static String region;
    private static int age;
    private static String about;
    private static Boolean isAdmin;

   /* public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }*/

    public User( int id, String username, String password, String name, String surname, String region, int age, String about, Boolean isAdmin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.region = region;
        this.age = age;
        this.about = about;
        this .isAdmin = isAdmin;
    }

    public User(String name, String surname, String region, int age, String about, Boolean isAdmin) {
        this.name = name;
        this.surname = surname;
        this.region = region;
        this.age = age;
        this.about = about;
        this .isAdmin = isAdmin;
    }

    public User(String username, String password, String name, String surname, String region, int age, String about, Boolean isAdmin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.region = region;
        this.age = age;
        this.about = about;
        this .isAdmin = isAdmin;
    }

    public User(){

    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        User.id = id;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        User.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        User.password = password;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        User.name = name;
    }

    public static String getSurname() {
        return surname;
    }

    public static void setSurname(String surname) {
        User.surname = surname;
    }

    public static String getRegion() {
        return region;
    }

    public static void setRegion(String region) {
        User.region = region;
    }

    public static int getAge() {
        return age;
    }

    public static void setAge(int age) {
        User.age = age;
    }

    public static String getAbout() {
        return about;
    }

    public static void setAbout(String about) {
        User.about = about;
    }

    public static Boolean getIsAdmin() {
        return isAdmin;
    }

    public static void setIsAdmin(Boolean isAdmin) {
        User.isAdmin = isAdmin;
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
