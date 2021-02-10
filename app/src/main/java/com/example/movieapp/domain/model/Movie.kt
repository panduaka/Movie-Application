package com.example.movieapp.domain.model

interface Movie {
    val id: String
}

data class MarvelMovie(
    override val id: String
) : Movie