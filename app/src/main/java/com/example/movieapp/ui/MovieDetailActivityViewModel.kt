package com.example.movieapp.ui

import androidx.lifecycle.ViewModel
import com.example.movieapp.domain.interactors.GetMovieDetailUseCase

class MovieDetailActivityViewModel(private val getMovieDetailUseCase: GetMovieDetailUseCase) : ViewModel() {
}