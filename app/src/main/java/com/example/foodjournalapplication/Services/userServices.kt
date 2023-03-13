package com.example.foodjournalapplication.Services

import android.content.Context
import android.util.Log
import com.example.foodjournalapplication.Entity.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

object userServices {
    fun getUsers(context: Context): List<User> {
        var jsonString = ""
        try {
            jsonString = context.assets.open("DummyUsers/Users.json")
                .bufferedReader()
                .use { it.readText() }
        } catch (ioException: IOException) {
            Log.d("Error", ioException.toString())
        }
        val listUserType = object : TypeToken<List<User>>() {}.type
        return Gson().fromJson(jsonString, listUserType)
    }
}