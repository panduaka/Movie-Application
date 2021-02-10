package com.example.movieapp.domain.interactors

import androidx.lifecycle.LiveData
import com.example.movieapp.cleanarch.UseCase
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) :
    UseCase<LiveData<Result<List<Movie>>>>, UseCaseScope {
    override fun execute(): LiveData<Result<List<Movie>>> {
        TODO("Not yet implemented")
    }

    override fun cancel() {
        TODO("Not yet implemented")
    }
}