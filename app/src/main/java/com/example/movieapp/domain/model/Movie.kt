package com.example.movieapp.domain.model

interface Movie {
    val id: String
    val movieName: String
}

data class MarvelMovie(
    override val id: String,
    override val movieName: String
) : Movie