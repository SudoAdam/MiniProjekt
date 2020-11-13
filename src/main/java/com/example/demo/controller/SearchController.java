package com.example.demo.controller;

import com.example.demo.domain.ResultUsers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;

import com.example.demo.database.DBSearch;
import com.example.demo.database.JDBCWriter;
import com.example.demo.domain.LogIn;
import com.example.demo.domain.User;
import com.example.demo.services.Search;

@Controller
public class SearchController {

    LogIn logIn = new LogIn();
    User user = new User();
    JDBCWriter jdbcWriter = new JDBCWriter();
    DBSearch dbSearch = new DBSearch();
    Search search = new Search();

    @GetMapping("/search")
    public String Search() {
        return "search";
    }

    @PostMapping("/searchResult")
    public String Result(WebRequest request,
                         @RequestParam int gender_id,
                         @RequestParam String minAge,
                         @RequestParam String maxAge,
                         @RequestParam String region) {
        search.writeStatement(gender_id, minAge, maxAge, region, user);
        return "redirect:/searchList";
    }

    @GetMapping("/searchList")
    public String searchList(Model model){
        ArrayList<ResultUsers> userSearchList = search.searchResult();
        model.addAttribute("users", userSearchList);
        System.out.println(userSearchList);
        return "searchList";
    }
}
