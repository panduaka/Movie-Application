package com.example.movieapp.domain.model

import com.google.gson.annotations.SerializedName

interface Movie {
    val movieTitle: String
}

data class MarvelMovie(
    override val movieTitle: String,
    val year: Int,
    val imdbID: String,
    val type: String,
    val poster: String
) : Movie