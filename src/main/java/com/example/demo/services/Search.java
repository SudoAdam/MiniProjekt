package com.example.demo.services;

import com.example.demo.database.DBSearch;
import com.example.demo.domain.ResultUsers;
import com.example.demo.domain.User;

import java.util.ArrayList;

public class Search {

    DBSearch dbSearch = new DBSearch();
    ArrayList<ResultUsers> results = new ArrayList<>();

public void writeStatement(String gender, String age, String region, String sex){
    String statement = "";

    if (age != ""){
        statement += ("age = '" + age + "' and ");
    }
    if (region != ""){
        statement += ("region like '%" + region + "%' and ");
    }

   results = dbSearch.search(statement);
}

}
