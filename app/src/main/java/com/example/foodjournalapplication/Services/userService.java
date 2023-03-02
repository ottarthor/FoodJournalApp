package com.example.foodjournalapplication.Services;

import com.example.foodjournalapplication.Entity.user;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;


public class userService {

    public void getUsers() throws JSONException, IOException {

            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                reader = Files.newBufferedReader(Paths.get("User.json"));
            }

            // convert a JSON string to a User object
            user user = gson.fromJson(reader,user.class);

            // print user object
            System.out.println(user);

            // close reader
            reader.close();

    }


}
