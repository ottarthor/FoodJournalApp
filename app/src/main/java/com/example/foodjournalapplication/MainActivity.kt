

package com.example.foodjournalapplication


import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
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

        val loginb = findViewById<Button>(R.id.LoginButtonID)
        loginb.setOnClickListener {
            /*val username = findViewById<EditText>(R.id.LoginUsernameAreaID).text
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

             */
            val username = findViewById<EditText>(R.id.LoginUsernameAreaID).text.toString()
            val password = findViewById<EditText>(R.id.LoginPasswordAreaID).text.toString()
            val errorMessage = findViewById<TextView>(R.id.errorMessage)

            var user = loginFunction(username,password)

            if(user == null){
                errorMessage.visibility = View.VISIBLE;
            }
            else{
                Log.d("ÚSERINN",user.username)
                val newRecIntent = Intent(this@MainActivity, HomeActivity::class.java)
                startActivity(newRecIntent)
            }

        }
    }

    fun loginFunction(username: String, password: String ): User? {
        var userList = userServices.getUsers(this);
        for (user in userList ){
            if(user.username == username){
                if(user.password == password){
                    return user;
                }
            }
        }
        return null;
    }
}
