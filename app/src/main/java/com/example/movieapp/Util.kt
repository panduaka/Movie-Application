package com.example.movieapp

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.core.content.ContextCompat

import androidx.core.content.ContextCompat.getSystemService


@Suppress("DEPRECATION")
class Util {
    companion object {
        fun isNetworkAvailable(app: Application): Boolean {
            val connectivityManager = app.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
            val activeNetworkInfo = connectivityManager!!.activeNetworkInfo
            return activeNetworkInfo?.isConnectedOrConnecting ?: false
        }
    }
}