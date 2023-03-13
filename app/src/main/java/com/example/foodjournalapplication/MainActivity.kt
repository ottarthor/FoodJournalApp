

package com.example.foodjournalapplication


import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import com.example.foodjournalapplication.Entity.User
import com.example.foodjournalapplication.Entity.recipe
import com.example.foodjournalapplication.NetworkManager.NetworkCallback
import com.example.foodjournalapplication.NetworkManager.NetworkManager
import com.example.foodjournalapplication.Services.userServices
import com.example.foodjournalapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val lts = findViewById<Button>(R.id.LoginSignupButtonID);
        lts.setOnClickListener {
            val ltsIntent = Intent(this@MainActivity, signupActivity::class.java);
            startActivity(ltsIntent);
        }

        /**
         * Checkar hvort user sé til í DB
         */
        val loginb = findViewById<Button>(R.id.LoginButtonID)
        loginb.setOnClickListener {
            val username = findViewById<EditText>(R.id.LoginUsernameAreaID).text
            val password = findViewById<EditText>(R.id.LoginPasswordAreaID).text
            val userL = User(
                username.toString(),
                password.toString()
            );

            var NM = NetworkManager.getInstance(this);
            NM!!.authUserPost(object : NetworkCallback<String> {
                override fun onSuccess(result: String) {
                    if (result != null) {
                        Log.d("RUFF", result)
                    }
                }

                override fun onFailure(errorString: String?) {
                    Log.d("TEST TOTODLSMKM", "EPIC Fail");
                }
                override fun getParams() {
                    Log.d("PARAMETER", "WOW");
                }
            }, userL)

            val loginIntent = Intent(this@MainActivity, SecondaryActivity::class.java)
            startActivity(loginIntent)
        }
    }
}
