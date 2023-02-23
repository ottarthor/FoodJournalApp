package com.example.foodjournalapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.foodjournalapplication.NetworkManager.NetworkCallback
import com.example.foodjournalapplication.NetworkManager.NetworkManager

class signupActivity : AppCompatActivity() {
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val stlb = findViewById<Button>(R.id.SignupLoginButtonID)
        stlb.setOnClickListener {
            val stlIntent = Intent(this@signupActivity, loginActivity::class.java)
            startActivity(stlIntent)
        }
    }
}
