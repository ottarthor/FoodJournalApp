package com.example.foodjournalapplication.Entity.Help;

import java.io.Serializable;

public class recipeParams implements Serializable{

    private String cooktime;
    private String preptime;
    private String rating;
    private String difficulty;
    private String vegetarian;
    private String vegan;
    private String dairyFree;
    private String glutenFree;
    private String calories;
    private String servings;

    public recipeParams(){}

    public recipeParams(String cooktime, String preptime, String rating, String difficulty, String vegetarian,
                        String vegan, String dairyFree, String glutenFree, String calories, String servings) {

        this.cooktime = cooktime;
        this.preptime = preptime;
        this.rating = rating;
        this.difficulty = difficulty;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
        this.dairyFree = dairyFree;
        this.glutenFree = glutenFree;
        this.calories = calories;
        this.servings = servings;
    }


    public String getCooktime() {
        return cooktime;
    }

    public void setCooktime(String cooktime) {
        this.cooktime = cooktime;
    }

    public String getPreptime() {
        return preptime;
    }

    public void setPreptime(String preptime) {
        this.preptime = preptime;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(String vegetarian) {
        this.vegetarian = vegetarian;
    }

    public String isVegan() {
        return vegan;
    }

    public void setVegan(String vegan) {
        this.vegan = vegan;
    }

    public String isDairyFree() {
        return dairyFree;
    }

    public void setDairyFree(String dairyFree) {
        this.dairyFree = dairyFree;
    }

    public String isGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(String glutenFree) {
        this.glutenFree = glutenFree;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getServings() {
        return servings;
    }

    public void setServings(String servings) {
        this.servings = servings;
    }


}
