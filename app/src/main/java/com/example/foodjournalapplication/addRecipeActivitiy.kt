package com.example.foodjournalapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

import com.example.foodjournalapplication.Entity.recipe
import com.example.foodjournalapplication.Entity.Help.recipeParams
import java.util.ArrayList


class addRecipeActivitiy : AppCompatActivity() {

    private var recipeList = ArrayList<recipe>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe_activitiy)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.disID, DescriptionFragment())
            commit()
        }

        val descriptionButton = findViewById<Button>(R.id.description_button)
        val ingredientButton = findViewById<Button>(R.id.ingredients_button)
        val stepsButton = findViewById<Button>(R.id.steps_button)

        descriptionButton.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.disID, DescriptionFragment()).commit()
        }

        ingredientButton.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.disID, IngredientFragment()).commit()
        }

        stepsButton.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.disID, StepsFragment()).commit()
        }

        if (intent.extras != null) {
            recipeList = intent.getSerializableExtra("RecipeList") as ArrayList<recipe>
        }

        val addrecipeButton = findViewById<Button>(R.id.addrecipeID)

        addrecipeButton.setOnClickListener{
            var recipeTitle = findViewById<EditText>(R.id.titleID).text.toString()
            recipeTitle = nullToString(recipeTitle)
            var recipeDesc = findViewById<EditText>(R.id.descriptionID).text.toString()
            recipeDesc = nullToString(recipeDesc)

            var recipePrepTime = findViewById<EditText>(R.id.prepTimeID).text.toString()
            recipePrepTime = nullToString(recipePrepTime)
            var recipeCooktime = findViewById<EditText>(R.id.cookTimeID).text.toString()
            recipeCooktime = nullToString(recipeCooktime)
            var recipeServings = findViewById<EditText>(R.id.servingsID).text.toString()
            recipeServings = nullToString(recipeServings)
            var recipeCalories = findViewById<EditText>(R.id.servingsID).text.toString()
            recipeCalories = nullToString(recipeCalories)

            var recipeVegan =  findViewById<CheckBox>(R.id.veganID).isChecked.toString()
            recipeVegan = nullToString(recipeVegan)
            var recipeVegetarian = findViewById<CheckBox>(R.id.vegetarianID).isChecked.toString()
            recipeVegetarian = nullToString(recipeVegetarian)
            var recipeDairyfree = findViewById<CheckBox>(R.id.dairyFreeID).isChecked.toString()
            recipeDairyfree = nullToString(recipeDairyfree)
            var recipeGlutenfree=  findViewById<CheckBox>(R.id.glutenFreeID).isChecked.toString()
            recipeGlutenfree = nullToString(recipeGlutenfree)

            val recipeParams = recipeParams(recipeCooktime,recipePrepTime,null,null,recipeVegetarian,
                recipeVegan,recipeDairyfree,recipeGlutenfree,recipeCalories,recipeServings)

            val newRecipe = recipe(recipeTitle,recipeDesc,recipeParams)

            val recipeCreatedIntent = Intent(this@addRecipeActivitiy, MainActivity::class.java)
            recipeCreatedIntent.putExtra("newRecipe", newRecipe)
            startActivity(recipeCreatedIntent)

        }



    }

    fun nullToString(s:String): String {
        if(s==null){
            return "";
        }
        else return s
    }
}
