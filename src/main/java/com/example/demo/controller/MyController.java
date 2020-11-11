package com.example.demo.controller;

import com.example.demo.database.DBManager;
import com.example.demo.database.DBSearch;
import com.example.demo.database.JDBCWriter;
import com.example.demo.domain.LogIn;
import com.example.demo.domain.User;
import com.example.demo.services.Search;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class MyController {

    LogIn logIn = new LogIn();
    User user = new User();
    JDBCWriter jdbcWriter = new JDBCWriter();
    DBSearch dbSearch = new DBSearch();
    Search search = new Search();


    @GetMapping("/")
    //@ResponseBody
    public String index() {
        DBManager.getConnection();
       return "index";
    }

    @GetMapping("/search")
    public String search() {
        //dbSearch.search("");

        return "search";
    }

    @GetMapping("/profil")
    public String profil(Model model) {
        String bruger = jdbcWriter.getUser(user.getId());
        System.out.println(bruger);
        model.addAttribute("id",bruger);
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

    @GetMapping("/update")
    public String update(){
        return "update";
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
            return "redirect:/createUserG";
        } else {
            System.out.println("der er gået noget galt");
        }

        System.out.println("id =" + id);
        return "search";

    }

    @GetMapping("/createUserG")
    public String createUser(Model model){
        model.addAttribute("user", new User());
        return "opret";
    }

    @PostMapping("/createUserP")
    public String createUser(
        @ModelAttribute User user,
        @RequestParam String username,
        @RequestParam String password,
        @RequestParam String name,
        @RequestParam String surname,
        @RequestParam String region,
        @RequestParam int age,
        @RequestParam String about,
        Model model){
            ArrayList<User> userList = new ArrayList<>();
            model.addAttribute("user", userList);
            System.out.println("Rasmus kode er god");
            User u = new User(username, password, name, surname, region, age, about);
            jdbcWriter.createUser(u);
            return "profil";
    }

    @PostMapping("/updateUserP")
    public String updateUser(
            @ModelAttribute User user,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String region,
            @RequestParam int age,
            @RequestParam String about,
            @RequestParam String date,
            Model modelUpdate){
                ArrayList<User> userUpList = new ArrayList<>();
                modelUpdate.addAttribute("user", userUpList);
                User u = new User(username, password, name, surname, region, age, about);
                jdbcWriter.updateUser(u);
                return "profil";
    }

    @PostMapping("/SearchResult")
    public String Result(
            @RequestParam String age,
            @RequestParam String region) {
        System.out.println(age);
        Search search = new Search();
        search.writeStatement("",age,region,"");
        return "/result";
    }
}
