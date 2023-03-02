package com.example.foodjournalapplication

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.foodjournalapplication.Entity.recipe


class recipeViewActivity : AppCompatActivity() {
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_view)
        var thisrecipe = recipe("none", "none")
        if (intent.extras != null) {
            thisrecipe = intent.getSerializableExtra("Recipe") as recipe
        }

         val nameField: TextView = findViewById<TextView>(R.id.recipe_name)
         val descField: TextView = findViewById<TextView>(R.id.recipe_desc)
         val cooktimeField: TextView = findViewById<TextView>(R.id.recipe_cooktime)
         val preptimeField: TextView = findViewById<TextView>(R.id.recipe_preptime)
         val vegeterianField: TextView = findViewById<TextView>(R.id.recipe_vegeterian)
         val veganField: TextView = findViewById<TextView>(R.id.recipe_vegan)
         val dairyfreeField: TextView = findViewById<TextView>(R.id.recipe_dairyfree)
         val glutenfreeField: TextView = findViewById<TextView>(R.id.recipe_glutenfree)
         val caloriesField: TextView = findViewById<TextView>(R.id.recipe_calories)
         val servingsField: TextView = findViewById<TextView>(R.id.recipe_servings)


         nameField.text = thisrecipe.name
         descField.text = thisrecipe.text
         cooktimeField.text = thisrecipe.params.cooktime
         preptimeField.text = thisrecipe.params.preptime
         vegeterianField.text = thisrecipe.params.isVegetarian
         veganField.text = thisrecipe.params.isVegan
         dairyfreeField.text = thisrecipe.params.isDairyFree
         glutenfreeField.text = thisrecipe.params.isGlutenFree
         caloriesField.text = thisrecipe.params.calories
         servingsField.text = thisrecipe.params.servings

    }

}


