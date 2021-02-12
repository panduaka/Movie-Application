package com.example.movieapp.data.mapper

import com.example.movieapp.data.model.Search
import com.example.movieapp.domain.model.MarvelMovie

fun searchMovies(movies: List<Search>?): List<MarvelMovie> {
    val marvelMovieList = mutableListOf<MarvelMovie>()
    movies?.forEach {
        marvelMovieList.add(
            MarvelMovie(
                movieTitle = it.title,
                year = it.year,
                imdbID = it.imdbID,
                type = it.type,
                poster = it.poster
            )
        )
    }
    return marvelMovieList
}