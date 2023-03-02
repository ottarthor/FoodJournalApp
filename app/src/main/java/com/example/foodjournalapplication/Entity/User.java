package com.example.foodjournalapplication.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private Long id;
    private String username;
    private String password;
    private String groceryWeek;

    private String temp_ingred;

    private String temp_amount;
    Map<String,String> weeklyGroceries = new HashMap<String, String >();;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Long getId() {
        return id;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroceryWeek() {
        return groceryWeek;
    }

    public void setGroceryWeek(String groceryWeek) {
        this.groceryWeek = groceryWeek;
    }

    public Map<String, String> getWeeklyGroceries() {
        return weeklyGroceries;
    }

    public void setWeeklyGroceries(Map<String, String> weeklyGroceries) {
        this.weeklyGroceries = weeklyGroceries;
    }

    public String getTemp_ingred() {
        return temp_ingred;
    }

    public String getTemp_amount() {
        return temp_amount;
    }

    public void setTemp_ingred(String temp_ingred) {
        this.temp_ingred = temp_ingred;
    }

    public void setTemp_amount(String temp_amount) {
        this.temp_amount = temp_amount;
    }

    public List<String> grocIngredToString(){
        List<String> list = new ArrayList<>();
        for(String key: weeklyGroceries.keySet()){
            list.add(key);
        }
        return list;
    }

    public List<String> grocAmountToString(){
        List<String> list = new ArrayList<>();
        for(String key: weeklyGroceries.values()){
            list.add(key);
        }
        return list;
    }

    public User() {
        groceryWeek = "null";
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        groceryWeek = "null";
    }

}

