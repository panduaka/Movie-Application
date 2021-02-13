package com.example.movieapp.data

import com.example.movieapp.cleanarch.Response
import com.example.movieapp.data.mapper.movieDetail
import com.example.movieapp.data.mapper.searchMovies
import com.example.movieapp.data.service.MovieService
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.model.MovieDetailDomain
import com.example.movieapp.domain.repository.MovieRepository

class MovieRepositoryImpl(private val movieService: MovieService) : MovieRepository {

    class ResponseException(message: String) : Exception(message)

    override suspend fun getMovies(searchKeyWord: String): Response<List<Movie>> {
        return try {
            val movies = movieService.getMovies(searchKeyWord)
            if (movies.isSuccessful) {
                Response.Success(searchMovies(movies = movies.body()?.search))
            } else {
                Response.Error(ResponseException(movies.message()))
            }
        } catch (e: Exception) {
            Response.Error(e)
        }
    }

    override suspend fun getMovieDetail(imdb: String): Response<MovieDetailDomain> {
        return try {
            val movieDetail = movieService.getMovieDetail(imdb)
            if (movieDetail.isSuccessful) {
                Response.Success(movieDetail(movieDetail = movieDetail.body()))
            } else {
                Response.Error(ResponseException(movieDetail.message()))
            }
        } catch (e: Exception) {
            Response.Error(e)
        }
    }
}