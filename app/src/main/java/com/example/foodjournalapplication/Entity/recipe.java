package com.example.foodjournalapplication.Entity;

import com.example.foodjournalapplication.Entity.Help.recipeParams;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class recipe implements Serializable {
    private Long UserID;
    private Long id;
    private String name;
    private String text;
    private String categories;

    private recipeParams params;

    Map<String, String> ingredients = new HashMap<String, String >();

    private String temp_ingred;

    private String temp_amount;
    private String photo;

    public recipe() {
    }

    /**
     * @param name The name of the recipe object
     * @param text The text of the recipe object
     * @param ingredients The ingredients of the recipe object
     */
    public recipe(String name, String text, HashMap<String,String> ingredients, Long userID, String categories) {
        this.name = name;
        this.text = text;
        this.UserID = userID;
        this.categories = categories;
    }

    public recipe(String name, String text){
        this.name=name;
        this.text=text;
    }

    /**
     * Temporary constructor for recipe until network manager will be accessible
     * @param name Name of the recipe
     * @param text Description for the recipe
     * @param params parameters of the recipe
     */
    public recipe(String name, String text, recipeParams params){
        this.name = name;
        this.text = text;
        this.params = params;
    }


    //getters and setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public Long getUserID() {
        return UserID;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setUserID(Long ID) {
        this.UserID=ID;
    }

    public Map<String, String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(HashMap<String, String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setIngredients(Map<String, String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
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

    public recipeParams getParams() {return params;}

    public void setParams(recipeParams params) {this.params = params;}

    public List<String> ingredToString(){
        List<String> list = new ArrayList<>();
        for(String key: ingredients.keySet()){
            list.add(key);
        }
        return list;
    }

    public List<String> amountToString(){
        List<String> list = new ArrayList<>();
        for(String key: ingredients.values()){
            list.add(key);
        }
        return list;
    }

}
