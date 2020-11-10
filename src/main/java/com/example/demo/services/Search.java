package com.example.demo.services;

import com.example.demo.database.DBSearch;
import com.example.demo.domain.User;

import java.util.ArrayList;

public class Search {

    DBSearch dbSearch = new DBSearch();
    ArrayList<User> results = new ArrayList<>();

public void writeStatement(String gender, String age, String region, String sex){
    String statement = "";

    if (age != ""){
        statement += ("age = '" + age + "' ,");
    }
    if (region != ""){
        statement += ("region like %" + region + "% ,");
    }

    dbSearch.search(statement);
}

}
