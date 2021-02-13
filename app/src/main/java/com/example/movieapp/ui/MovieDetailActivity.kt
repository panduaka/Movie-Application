package com.example.movieapp.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.movieapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailActivity : AppCompatActivity() {
    private val viewModel by viewModel<MovieDetailActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imdb = intent.getStringExtra(MainActivity.IMDB)
        Log.d("MovieDetailActivity", imdb.toString())

        viewModel.run {
            onMovieLoaded.observe(this@MovieDetailActivity, Observer {

            })
        }
        viewModel.imdb.postValue(imdb)

    }
}