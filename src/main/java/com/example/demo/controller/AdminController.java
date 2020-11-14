package com.example.demo.controller;

import com.example.demo.database.DBSearch;
import com.example.demo.database.JDBCWriter;
import com.example.demo.domain.LogIn;
import com.example.demo.domain.User;
import com.example.demo.services.Search;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    LogIn logIn = new LogIn();
    User user = new User();
    JDBCWriter jdbcWriter = new JDBCWriter();
    DBSearch dbSearch = new DBSearch();
    Search search = new Search();

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/adminProfil")
    public String adminProfil() {
        return "adminProfil";
    }

    @PostMapping("/removeduser")
    public String removeduser(@RequestParam int userID) {
        jdbcWriter.removeUser(userID);
        return "adminProfil";
    }
}
