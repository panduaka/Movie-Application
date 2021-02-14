package com.example.movieapp.domain.interactors

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movieapp.cleanarch.Response
import com.example.movieapp.cleanarch.Result
import com.example.movieapp.cleanarch.UseCaseWithParameter
import com.example.movieapp.domain.model.MovieDetailDomain
import com.example.movieapp.domain.repository.MovieRepository
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class GetMovieDetailUseCase(private val movieRepository: MovieRepository) :
    UseCaseWithParameter<String, LiveData<Result<MovieDetailDomain>>>, UseCaseScope {

    override fun execute(parameter: String): LiveData<Result<MovieDetailDomain>> {
        val result = MutableLiveData<Result<MovieDetailDomain>>()
        result.postValue(Result.Loading)
        launch {
            val toPost = when (val response = movieRepository.getMovieDetail(parameter)) {
                is Response.Success -> Result.Success(response.data)
                is Response.Error -> Result.Error(response.exception)
            }
            result.postValue(toPost)
        }

        return result
    }

    override fun cancel() {
        coroutineContext.cancel()
    }

}