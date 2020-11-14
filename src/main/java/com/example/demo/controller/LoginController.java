package com.example.demo.controller;

import com.example.demo.database.DBSearch;
import com.example.demo.database.JDBCWriter;
import com.example.demo.domain.LogIn;
import com.example.demo.domain.User;
import com.example.demo.services.Search;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@Controller
public class LoginController {
    LogIn logIn = new LogIn();
    User user = new User();
    JDBCWriter jdbcWriter = new JDBCWriter();
    DBSearch dbSearch = new DBSearch();
    Search search = new Search();

    @PostMapping("/logIn")
    public String logIn(WebRequest request, @RequestParam String username, @RequestParam String password, @RequestParam int action) {
        //forsøg på at få index formen til både at kunne logge ind og oprette
        System.out.println("Så langt så godt");
        int id = -1;

        if (action == 1) {
            System.out.println("login tried");
            //log in action

            if (logIn.login(username, password) != null) {
                user = logIn.login(username, password);
                request.setAttribute("user", user, WebRequest.SCOPE_SESSION);
                if (user.getAdmin() == true) {
                    // user = logIn.login(username, password);
                    return "adminProfil";
                } else {
                    return "profil";
                }
            } else {
                return "index";
            }

        } else if (action == 2) {
            System.out.println("create tried");
            logIn.create(username, password);
            return "redirect:/createUserG";
        } else {
            System.out.println("der er gået noget galt");
        }

        System.out.println("id =" + id);
        return "search";
    }

    @PostMapping("/adminLogIn")
    public String adminLogIn(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam int action,
            @RequestParam boolean isAdmin,
            Model model) {
        //forsøg på at få index formen til både at kunne logge ind og oprette
        System.out.println("Så langt så godt");
        int id = -1;

        if (action == 1) {
            System.out.println("login tried");
            //log in action

            if (logIn.login(username, password) != null) {
                if (isAdmin == true) {
                    user = logIn.login(username, password);
                    return "adminProfil";
                } else {
                    System.out.println("You're not an admin");
                }
            } else {
                return "index";
            }

        } else {
            System.out.println("der er gået noget galt");
        }
        System.out.println("id =" + id);
        return "search";
    }

    @GetMapping("/logout")
    public String logout() {
        logIn.logout();
        return "index";
    }

}
