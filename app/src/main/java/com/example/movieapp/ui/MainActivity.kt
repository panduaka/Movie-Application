package com.example.movieapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.movieapp.R
import com.example.movieapp.domain.model.MarvelMovie
import com.example.movieapp.domain.model.Movie
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainActivityViewModel>()
    private val adapter = MovieAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridLayoutManager = StaggeredGridLayoutManager(
           2,
            StaggeredGridLayoutManager.VERTICAL
        )
        movieRecyclerView.layoutManager = gridLayoutManager

        movieRecyclerView.adapter = adapter

        //Wire inputs
        viewModel.run {
            onMoviesLoaded.observe(this@MainActivity, Observer {
                adapter.movieItems = it
            })
        }

        //Wire Outputs
        search_button.setOnClickListener {
            val searchKeyWord = search_edittext.text.toString()
            viewModel.onSearchMovies.postValue(searchKeyWord)
        }
    }
}