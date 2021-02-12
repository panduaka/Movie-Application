package com.example.movieapp.ui

import androidx.lifecycle.ViewModel
import com.example.movieapp.domain.interactors.GetMoviesUseCase

class MainActivityViewModel(private val getMoviesUseCase: GetMoviesUseCase): ViewModel() {
}