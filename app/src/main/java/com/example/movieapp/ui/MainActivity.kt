package com.example.movieapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.movieapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getMarvelMovieList

//        val scope = CoroutineScope(context = )

//        scope.launch {
//            getMo
//        }

//        val net = Util.isNetworkAvailable(application)
    }
}