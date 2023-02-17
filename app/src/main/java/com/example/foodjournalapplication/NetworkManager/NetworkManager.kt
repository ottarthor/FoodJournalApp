package com.example.foodjournalapplication.NetworkManager

import android.content.Context
import android.text.style.TtsSpan
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

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

    fun getTest(callback: NetworkCallback<String>) {
        val request = StringRequest(
            Request.Method.GET, "$BASE_URL/test", { response: String ->
                //var gson = Gson()
                //var stringType = TypeToken<String>(){}.type;
                //var answer = gson.fromJson(response, stringType);
                callback.onSuccess(response)
            }
        ) { error: VolleyError -> callback.onFailure(error.toString()) }
        mQueue!!.add(request);
    }


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