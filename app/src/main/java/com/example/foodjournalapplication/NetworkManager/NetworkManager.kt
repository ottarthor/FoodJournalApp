package com.example.foodjournalapplication.NetworkManager

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.example.foodjournalapplication.Entity.User

class NetworkManager private constructor(private val mContext: Context) {
    init {
        mQueue = requestQueue
    }

    private val requestQueue: RequestQueue?
        get() {
            if (mQueue == null) {
                mQueue = Volley.newRequestQueue(mContext.applicationContext)
            }
            return mQueue
        }

    /*fun getTest(callback: NetworkCallback<String>) {
        val request = StringRequest(
            Request.Method.GET, "$BASE_URL/test", { response: String ->
                //var gson = Gson()
                //var stringType = TypeToken<String>(){}.type;
                //var answer = gson.fromJson(response, stringType);
                callback.onSuccess(response)
            }
        ) { error: VolleyError -> callback.onFailure(error.toString()) }
        mQueue!!.add(request)
    }
     */

   /* fun authUser(callback: NetworkCallback<user>){
        val request = StringRequest(
            Request.Method.GET, "$BASE_URL/login_app", { response: String ->
                var gson = Gson()
                var answer = gson.fromJson(response,Boolean::class.java);
                callback.onSuccess(answer)
            }
        ) { error: VolleyError -> callback.onFailure(error.toString()) }
        mQueue!!.add(request)
    }

    fun authUserPost(callback: NetworkCallback<User>, user: User){
        val request = object: StringRequest(
            Method.GET, "$BASE_URL/login_app", { response: String ->
                var gson = Gson()
                var answer = gson.fromJson(response, user::class.java);
                callback.onSuccess(answer)
            },

        { error: VolleyError -> callback.onFailure(error.toString()) }) {
            override fun getParams(): Map<String, String> {
                val params: MutableMap<String, String> = HashMap()
                params["username"] = user.username
                params["password"] = user.password
                return params
            }
        }
        mQueue!!.add(request)
    }
    */


    companion object {
        private const val BASE_URL = "https://foodjournal-production.up.railway.app"
        private var mInstance: NetworkManager? = null
        private var mQueue: RequestQueue? = null

        @Synchronized
        fun getInstance(context: Context): NetworkManager? {
            if (mInstance == null) {
                mInstance = NetworkManager(context)
            }
            return mInstance
        }
    }
}

