package com.example.movieapp.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.movieapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Wire inputs
        viewModel.run {
            onMoviesLoaded.observe(this@MainActivity, Observer {
                it
                Log.d("Activity","Loaded")
            })
        }

        //Wire Outputs
        viewModel.onSearchMovies.postValue("Iron")
    }
}