package com.example.movieapp.ui

import androidx.lifecycle.*
import com.example.movieapp.cleanarch.Result
import com.example.movieapp.domain.interactors.GetMovieDetailUseCase
import com.example.movieapp.domain.model.MovieDetailDomain

class MovieDetailActivityViewModel(private val getMovieDetailUseCase: GetMovieDetailUseCase) : ViewModel() {
    // Inputs
    val imdb = MutableLiveData<String>()

    //Outputs
    internal val onMovieLoaded: LiveData<MovieDetailDomain> get() = _onMovieLoaded

    // Transformations
    private val getMoviesResult: LiveData<Result<MovieDetailDomain>> = Transformations.switchMap(imdb) {
        getMovieDetailUseCase.execute(it)
    }

    private val _onMovieLoaded = MediatorLiveData<MovieDetailDomain>()

    init {
        _onMovieLoaded.addSource(getMoviesResult) {
            if (it is Result.Success) {
                _onMovieLoaded.postValue(
                    it.data
                )
            }
        }
    }
}