package com.example.foodjournalapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class MyRecipesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_recipes)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomnav);
        bottomNavigationView.selectedItemId = R.id.navigation_home
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_recipes -> true
                R.id.navigation_search -> {
                    startActivity(Intent(applicationContext, SearchRecipeActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.navigation_grocerylist -> {
                    startActivity(Intent(applicationContext, GroceryListActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.navigation_calendar -> {
                    startActivity(Intent(applicationContext, MainCalendarActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.navigation_home-> {
                    startActivity(Intent(applicationContext, HomeActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }

                else -> false
            }
        }
    }
}