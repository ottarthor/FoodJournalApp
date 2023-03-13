package com.example.foodjournalapplication

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.foodjournalapplication.Entity.recipe
import com.example.foodjournalapplication.NetworkManager.NetworkCallback
import com.example.foodjournalapplication.NetworkManager.NetworkManager
import com.example.foodjournalapplication.Services.userServices
import com.example.foodjournalapplication.databinding.ActivityMainBinding

class SecondaryActivity : AppCompatActivity() {


    private lateinit var test: String

    private lateinit var binding: ActivityMainBinding

    private var PICK_IMAGE_REQUEST: Int = 99;
    private lateinit var imagePath: Uri;
    private lateinit var imageToStore: Bitmap;

    private var telja = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        val mynd = findViewById<Button>(R.id.myndbutton)
        mynd.setOnClickListener {
            val myndIntent = Intent(this@SecondaryActivity, photoActivity::class.java)
            startActivity(myndIntent)
        }

        /*
        val us = userServices()
        us.getUsers()
        */


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
        })

         */

        val mLayout = findViewById<LinearLayout>(R.id.SVLayout)
        val buttonNewRec = findViewById<Button>(R.id.NewRecipeButton)

        val loginb = findViewById<Button>(R.id.loginB)
        loginb.setOnClickListener {
            val loginIntent = Intent(this@SecondaryActivity, loginActivity::class.java)
            startActivity(loginIntent)
        }

        val loginb2 = findViewById<Button>(R.id.loginB2)
        loginb2.setOnClickListener {
            val signupIntent = Intent(this@SecondaryActivity, signupActivity::class.java)
            startActivity(signupIntent)
        }

        val calendarB = findViewById<Button>(R.id.calendarB)
        calendarB.setOnClickListener {
            val calendarIntent = Intent(this@SecondaryActivity, MainCalendarActivity::class.java)
            startActivity(calendarIntent)
        }

        buttonNewRec.setOnClickListener{
            val newRecIntent = Intent(this@SecondaryActivity, addRecipeActivitiy::class.java)
            startActivity(newRecIntent)
        }

        if (intent.extras != null) {
            val newRecipe = intent.getSerializableExtra("newRecipe") as recipe
            val recipeButton = Button(this@SecondaryActivity)
            val ViewInt = Intent(this@SecondaryActivity, recipeViewActivity::class.java)
            val mLayout = findViewById<ScrollView>(R.id.scrollView3);
            mLayout.addView(recipeButton)
            ViewInt.putExtra("Recipe", newRecipe)
            recipeButton.setText(newRecipe.name)
            recipeButton.setOnClickListener{
                startActivity(ViewInt)
            }
        }


        /*
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
         */




        Log.d("NJSK","EFTIR");

        binding = ActivityMainBinding.inflate(layoutInflater)
        //navView.setupWithNavController(navController)

        val buttonUsers = findViewById<Button>(R.id.GetUsers)
        buttonUsers.setOnClickListener{
            onClickUsers();
        }
    }
    fun onClickUsers() {
        var UserList = userServices.getUsers(this);
        for (user in UserList ){
            Log.d("TEST", user.username)
        }
    }
}