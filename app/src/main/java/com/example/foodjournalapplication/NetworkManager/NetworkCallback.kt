package com.example.foodjournalapplication.NetworkManager

interface NetworkCallback<T> {
    fun onSuccess(result: T)
    fun onFailure(errorString: String?)
}