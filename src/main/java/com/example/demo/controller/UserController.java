package com.example.demo.controller;

import com.example.demo.database.DBSearch;
import com.example.demo.database.JDBCWriter;
import com.example.demo.domain.LogIn;
import com.example.demo.domain.User;
import com.example.demo.services.Search;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;

@Controller
public class UserController {

    LogIn logIn = new LogIn();
    User user = new User();
    JDBCWriter jdbcWriter = new JDBCWriter();
    DBSearch dbSearch = new DBSearch();
    Search search = new Search();

    @GetMapping("/about")
    public String about() {
        return "omos";
    }

    @GetMapping("/createUserG")
    public String createUser(Model model) {
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
            @RequestParam String imageLink,
            @RequestParam int gender_id) {
        //ArrayList<User> userList = new ArrayList<>();
        //model.addAttribute("user", userList);
        System.out.println("Rasmus kode er god");
        System.out.println(imageLink);
        User u = new User(username, password, name, surname, region, age, about, false, imageLink, gender_id);
        jdbcWriter.createUser(u);
        return "index";
    }

    @GetMapping("/profil")
    public String profil(Model model) {
        String bruger = jdbcWriter.getUser(user.getId());
        System.out.println(bruger);
        model.addAttribute("id", bruger);
        return "profil";
    }

    @GetMapping("/visProfil")
    public String visProfil(Model model) {
        model.addAttribute("name", user.getName());
        model.addAttribute("surname", user.getSurname());
        model.addAttribute("region", user.getRegion());
        model.addAttribute("age", user.getAge());
        model.addAttribute("about", user.getAbout());
        return "profil";
    }

    @GetMapping("/update")
    public String update(Model model) {
        model.addAttribute("user", new User());
        return "update";
    }

    @PostMapping("/updateUserP")
    public String updateUser(WebRequest request,
                             @RequestParam String name,
                             @RequestParam String surname,
                             @RequestParam String region,
                             @RequestParam int age,
                             @RequestParam String about,
                             @RequestParam String imageLink,
                             Model modelUpdate) {
        ArrayList<User> userUpList = new ArrayList<>();
        modelUpdate.addAttribute("user", userUpList);
        User u = new User(user.getId(), user.getUsername(), user.getPassword(), name, surname, region, age, about, false, user.getGender_id(), user.getImageLink());
        jdbcWriter.updateUser(u);
        request.setAttribute("user", u, WebRequest.SCOPE_SESSION);
        return "redirect:/visProfil";
    }
}
