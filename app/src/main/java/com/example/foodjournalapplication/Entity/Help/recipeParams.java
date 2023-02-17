package is.hi.hbv601g.foodjournal.Entity.Help;

import java.io.Serializable;

public class recipeParams {

    private int cooktime;
    private int preptime;
    private int rating;
    private String difficulty;
    private boolean vegetarian;
    private boolean vegan;
    private boolean dairyFree;
    private boolean glutenFree;
    private int calories;
    private int servings;

    public recipeParams(){}

    public recipeParams(int cooktime, int preptime, int rating, String difficulty, boolean vegetarian,
                        boolean vegan, boolean dairyFree, boolean glutenFree, int calories, int servings) {

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

    public int getCooktime() {
        return cooktime;
    }

    public void setCooktime(int cooktime) {
        this.cooktime = cooktime;
    }

    public int getPreptime() {
        return preptime;
    }

    public void setPreptime(int preptime) {
        this.preptime = preptime;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isDairyFree() {
        return dairyFree;
    }

    public void setDairyFree(boolean dairyFree) {
        this.dairyFree = dairyFree;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }


}
