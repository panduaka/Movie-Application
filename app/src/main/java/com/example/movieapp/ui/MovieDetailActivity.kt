package com.example.movieapp.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.movieapp.R
import com.example.movieapp.util.loadImage
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailActivity : AppCompatActivity() {
    private val viewModel by viewModel<MovieDetailActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imdb = intent.getStringExtra(MainActivity.IMDB)
        Log.d("MovieDetailActivity", imdb.toString())

        viewModel.run {
            onMovieLoaded.observe(this@MovieDetailActivity, {
                mainCollapsing.title = it.title
                it.poster?.let { _poster ->
                    this@MovieDetailActivity.loadImage(_poster, R.drawable.ic_launcher_background, mainBackdrop, false)
                }
                gridTitle.text = it.title
                year.text = "Released in ${it.year.toString()}"
                runtime.text = it.runtime
                director.text = it.director
                genre.text = it.genre
                actors.text = it.actors
                plot.text = it.plot
                val ratingO = it.ratings?.get(0)
                rating.text = "${ratingO?.source }  ${ratingO?.value }"

//                val imdbRating = it.ratings?.filter { it.source == "imdbRating" }


            })
        }
        viewModel.imdb.postValue(imdb)

    }
}