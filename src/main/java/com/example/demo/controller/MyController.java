package com.example.demo.controller;

import com.example.demo.user.LogIn;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
    LogIn logIn = new LogIn();

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/ommig")
    public String omMig() {
        return "omMig";
    }


    //hugget fra gammel projekt !på ingen måde færdigt!
    @PostMapping("/logIn")
    public String logIn(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String action) {
        //forsøg på at få index formen til både at kunne logge ind og oprette
        if (action == "login") {
            System.out.println("login tried");
            logIn.login(username, password);
        } else if (action == "create") {
            System.out.println("create tried");
            logIn.create(username, password);
        } else {
            System.out.println("der er gået noget galt");
        }
        return "omMig";

    }

    //hugget fra gammel projekt !på ingen måde færdigt!
    @PostMapping("/createUser")
    public String createUser(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {
        return "confirmation";
    }
}
