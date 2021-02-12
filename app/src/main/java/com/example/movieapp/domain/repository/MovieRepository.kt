package com.example.movieapp.domain.repository

import com.example.movieapp.cleanarch.Response
import com.example.movieapp.domain.model.Movie

interface MovieRepository {
    suspend fun getMovies(): Response<List<Movie>>
}