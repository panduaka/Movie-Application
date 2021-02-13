package com.example.movieapp.ui

import androidx.lifecycle.*
import com.example.movieapp.cleanarch.Result
import com.example.movieapp.domain.interactors.GetMoviesUseCase
import com.example.movieapp.domain.model.Movie

class MainActivityViewModel(private val getMoviesUseCase: GetMoviesUseCase) : ViewModel() {

    // Inputs
    val onSearchMovies = MutableLiveData<String>()

    //Outputs
    internal val onMoviesLoaded: LiveData<List<Movie>> get() = _onMoviesLoaded

    // Transformations
    private val getMoviesResult: LiveData<Result<List<Movie>>> = Transformations.switchMap(onSearchMovies) {
        getMoviesUseCase.execute(it)
    }

    private val _onMoviesLoaded = MediatorLiveData<List<Movie>>()

    init {
        _onMoviesLoaded.addSource(getMoviesResult) {
            if (it is Result.Success) {
                _onMoviesLoaded.postValue(
                    it.data
                )
            }
        }
    }
}