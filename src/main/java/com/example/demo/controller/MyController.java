package com.example.demo.controller;

import com.example.demo.user.LogIn;
import com.example.demo.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
    LogIn logIn = new LogIn();
    User user = new User();

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/search")
    public String search() {
        return "search";
    }


    //hugget fra gammel projekt !på ingen måde færdigt!
    @GetMapping("/logIn")
    public String logIn(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam int action,
            Model model) {
        //forsøg på at få index formen til både at kunne logge ind og oprette
        System.out.println("Så langt så godt");
        if (action == 1) {
            System.out.println("login tried");
           user = logIn.login(username, password);
            System.out.println(user);
        } else if (action == 2) {
            System.out.println("create tried");
            //logIn.create(username, password);
        } else {
            System.out.println("der er gået noget galt");
        }

        return "search";

    }
/*
    //hugget fra gammel projekt !på ingen måde færdigt!
    @PostMapping("/createUser")
    public String createUser(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {
        return "confirmation";
    }*/
}
