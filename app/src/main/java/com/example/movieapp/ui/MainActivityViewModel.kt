package com.example.movieapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.movieapp.domain.interactors.GetMoviesUseCase
import com.example.movieapp.domain.model.Movie

class MainActivityViewModel(getMoviesUseCase: GetMoviesUseCase) : ViewModel() {
    // Transformations
    val getJournalResult = getMoviesUseCase.execute()
}