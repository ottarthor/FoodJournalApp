package com.example.foodjournalapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.foodjournalapplication.Entity.recipe
import com.example.foodjournalapplication.NetworkManager.NetworkCallback
import com.example.foodjournalapplication.NetworkManager.NetworkManager
import com.example.foodjournalapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var test: String

    private lateinit var binding: ActivityMainBinding

    private var telja = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        var NM = NetworkManager.getInstance(this);
        /*NM!!.getTest(object : NetworkCallback<String> {
            override fun onSuccess(result: String) {
                if (result != null) {
                    test = result
                };
                Log.d("SDFNJSDFN", test);
            }
            override fun onFailure(errorString: String?) {
                Log.d("TEST TOTODLSMKM", "EPIC Fail");
            }

            override fun getParams() {
                TODO("Not yet implemented")
            }
        })

         */

        val mLayout = findViewById<LinearLayout>(R.id.SVLayout)
        val button = findViewById<Button>(R.id.NewRecipeButton)

       val loginb = findViewById<Button>(R.id.loginB)
        loginb.setOnClickListener {
            val loginIntent = Intent(this@MainActivity, loginActivity::class.java)
            startActivity(loginIntent)
        }


        button.setOnClickListener {
            val takki = Button(this@MainActivity)
            takki.setOnClickListener {
                val ViewInt = Intent(this@MainActivity, recipeViewActivity::class.java)
                val s = "Recipe nr " + Integer.toString(telja)
                telja++
                val sendRecipe = recipe(s, "letsgooo")
                ViewInt.putExtra("Recipe", sendRecipe)
                startActivity(ViewInt)
            }
            mLayout.addView(takki)
        }

        Log.d("NJSK","EFTIR");

        binding = ActivityMainBinding.inflate(layoutInflater)
        //navView.setupWithNavController(navController)
    }
}