package com.example.movieapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.movieapp.R
import kotlinx.android.synthetic.main.activity_main.*
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
            })
        }

        //Wire Outputs
        search_button.setOnClickListener {
            val searchKeyWord = search_edittext.text.toString()
            viewModel.onSearchMovies.postValue(searchKeyWord)
        }

    }
}