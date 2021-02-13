package com.example.movieapp.data.mapper

import com.example.movieapp.data.model.MovieDetail
import com.example.movieapp.data.model.Search
import com.example.movieapp.domain.model.MarvelMovie
import com.example.movieapp.domain.model.MovieDetailDomain

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

fun movieDetail(movieDetail: MovieDetail?): MovieDetailDomain {
    return MovieDetailDomain(
        title = movieDetail?.title,
        year = movieDetail?.year,
        rated = movieDetail?.rated,
        released = movieDetail?.released,
        runtime = movieDetail?.runtime,
        genre = movieDetail?.genre,
        director = movieDetail?.director,
        writer = movieDetail?.writer,
        actors = movieDetail?.actors,
        plot = movieDetail?.plot,
        language = movieDetail?.language,
        country = movieDetail?.country,
        awards = movieDetail?.awards,
        poster = movieDetail?.poster,
        ratings = movieDetail?.ratings,
        metaScore = movieDetail?.metascore,
        imdbRating = movieDetail?.imdbRating,
        imdbVotes = movieDetail?.imdbVotes,
        imdbID = movieDetail?.imdbID,
        type = movieDetail?.type,
        dVD = movieDetail?.dVD,
        boxOffice = movieDetail?.boxOffice,
        production = movieDetail?.production,
        website = movieDetail?.website,
        response = movieDetail!!.response
    )
}