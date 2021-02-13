package com.example.movieapp.domain.repository

import com.example.movieapp.cleanarch.Response
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.model.MovieDetailDomain

interface MovieRepository {
    suspend fun getMovies(searchKeyWord: String): Response<List<Movie>>
    suspend fun getMovieDetail(imdb: String): Response<MovieDetailDomain>
}