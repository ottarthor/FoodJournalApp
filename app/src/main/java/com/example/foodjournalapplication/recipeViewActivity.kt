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
        nameField.text = thisrecipe.name
        descField.text = thisrecipe.text
    }

}


