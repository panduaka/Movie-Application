package com.example.movieapp.domain.model

import com.example.movieapp.data.model.Ratings

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

data class MovieDetailDomain(
    val title: String?,
    val year: Int?,
    val rated: String?,
    val released: String?,
    val runtime: String?,
    val genre: String?,
    val director: String?,
    val writer: String?,
    val actors: String?,
    val plot: String?,
    val language: String?,
    val country: String?,
    val awards: String?,
    val poster: String?,
    val ratings: List<Ratings>?,
    val metaScore: Int?,
    val imdbRating: Double?,
    val imdbVotes: String?,
    val imdbID: String?,
    val type: String?,
    val dVD: String?,
    val boxOffice: String?,
    val production: String?,
    val website: String?,
    val response: Boolean
)

data class Ratings(
    val source: String?,
    val value: String?
)