package com.example.demo.services;

import com.example.demo.database.DBSearch;
import com.example.demo.domain.ResultUsers;
import com.example.demo.domain.User;

import java.util.ArrayList;

public class    Search {

    DBSearch dbSearch = new DBSearch();
    ArrayList<ResultUsers> results = new ArrayList<>();

public void writeStatement(int gender_id, String minAge, String maxAge, String region, User user){
    String statement = "";
    System.out.println("nu er du her");

    if (gender_id != 0){
        statement += ("gender_id = '" + gender_id + "' and ");
    }
    if (minAge != "" &&  maxAge != "" ){
        statement += ("age BETWEEN '" + minAge + "' and '" + maxAge + "' and ");
    }
    if (region != ""){
        statement += ("region like '%" + region + "%' and ");
    }

    //statement += ("gender = '" + gender + "' ");
    System.out.println(statement);
   results = dbSearch.search(statement, user);
    System.out.println("når jeg hertil?");
}
public ArrayList<ResultUsers> searchResult(){
    return results;
}
}
