package com.example.demo.controller;

import com.example.demo.database.DBManager;
import com.example.demo.database.JDBCWriter;
import com.example.demo.domain.LogIn;
import com.example.demo.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    LogIn logIn = new LogIn();
    User user = new User();
    JDBCWriter jdbcWriter = new JDBCWriter();


    @GetMapping("/")
    @ResponseBody
    public String index() {
       return DBManager.getConnection().toString();
    }

    @GetMapping("/search")
    public String search() {
        return "search";
    }

    @GetMapping("/ommig")
    public String ommig() {
        System.out.println(user);
        return "ommig";
    }
    @GetMapping("/profil")
    public String profil() {
        String bruger = jdbcWriter.getUser(user.getId());
        System.out.println(bruger);
        return "profil";
    }

    @GetMapping("/about")
    public String about() {
        return "omos";
    }

    @GetMapping("/karantæne")
    public String karantæne() {
        return "karantæne";
    }


    //hugget fra gammel projekt !på ingen måde færdigt!
    @PostMapping("/logIn")
    public String logIn(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam int action,
            Model model) {
        //forsøg på at få index formen til både at kunne logge ind og oprette
        System.out.println("Så langt så godt");
        int id = -1;

        if (action == 1) {
            System.out.println("login tried");
            //log in action

            if (logIn.login(username, password) != null) {
                user = logIn.login(username, password);
                return "profil";
            } else {
                return "index";
            }

        } else if (action == 2) {
            System.out.println("create tried");
            logIn.create(username, password);

        } else {
            System.out.println("der er gået noget galt");
        }

        System.out.println("id =" + id);
        return "search";

    }

    //hugget fra gammel projekt !på ingen måde færdigt!
    @PostMapping("/createUser")
    public String createUser(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {
        //find en måde at parse de 2 info videre til create...
       /* if (logIn.userExsist(username) == false) {
            return "createUser";
        } else {
            return "userAlreadyExsists";
        }*/
        return null; // skal ikke bruges.
    }

}
