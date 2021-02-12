package com.example.movieapp.data

import com.example.movieapp.cleanarch.Response
import com.example.movieapp.data.service.MovieService
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.repository.MovieRepository

class MovieRepositoryImpl(private val movieService: MovieService) : MovieRepository {
    override suspend fun getMovies(): Response<List<Movie>> {
        return try {
            val movies = movieService.getMovies("Iron")
            Response.Success(listOf())
        } catch (e: Exception) {
            Response.Error(e)
        }
    }
}