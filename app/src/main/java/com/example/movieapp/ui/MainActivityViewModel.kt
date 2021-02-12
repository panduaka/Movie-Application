package com.example.movieapp.ui

import androidx.lifecycle.ViewModel
import com.example.movieapp.domain.interactors.GetMoviesUseCase

class MainActivityViewModel(getMoviesUseCase: GetMoviesUseCase) : ViewModel() {
    // Transformations
    val getMarvelMovieList = getMoviesUseCase.execute()
}