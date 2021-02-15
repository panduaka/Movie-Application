package com.example.movieapp.data.mapper

import com.example.movieapp.data.model.MovieDetail
import com.example.movieapp.data.model.Ratings
import com.example.movieapp.data.model.Search
import com.example.movieapp.domain.model.MarvelMovie
import com.example.movieapp.domain.model.MovieDetailDomain
import com.google.gson.annotations.SerializedName
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class MovieMapperKtTest {
    @Test
    fun convertMovieListToMarvelMovieList() {
        //Given
        val movieList: List<Search> = listOf(
            Search(
                title = "Thor", year = 2000, imdbID = "IMDB_Thor", type = "Marvel", poster = ""
            )
        )

        val marvelMovieList: List<MarvelMovie> = listOf(
            MarvelMovie(
                movieTitle = "Thor", year = 2000, imdbID = "IMDB_Thor", type = "Marvel", poster = ""
            )
        )

        //When
        val expectedResult = searchMovies(movieList)

        //Then
        assertEquals(expectedResult, marvelMovieList)

    }

    @Test
    fun movieDetail() {
        //Given
        val movieDetail = MovieDetail(
            title = "Thor",
            year = 2000,
            imdbID = "IMDB_Thor",
            type = "Marvel",
            poster = "",
            released = "2001",
            rated = "rated",
            genre = "Action Thriller",
            runtime = "2hours",
            director = "James",
            plot = "Plot",
            language = "English",
            country = "USA",
            awards = "Oscar",
            ratings = listOf(
                Ratings(
                    source = "IMDB",
                    value = "7.8"
                )
            ),
            metascore = 10,
            imdbRating = 7.8,
            imdbVotes = "234",
            dVD = "DVD",
            boxOffice = "Box Office",
            production = "Marvel",
            website = "Movie Hub",
            response = true,
            writer = "James",
            actors = "Chris Hemsworth"
        )

        val movieDomain = MovieDetailDomain(
            title = "Thor",
            year = 2000,
            imdbID = "IMDB_Thor",
            type = "Marvel",
            poster = "",
            released = "2001",
            rated = "rated",
            genre = "Action Thriller",
            runtime = "2hours",
            director = "James",
            plot = "Plot",
            language = "English",
            country = "USA",
            awards = "Oscar",
            ratings = listOf(
                Ratings(
                    source = "IMDB",
                    value = "7.8"
                )
            ),
            metaScore = 10,
            imdbRating = 7.8,
            imdbVotes = "234",
            dVD = "DVD",
            boxOffice = "Box Office",
            production = "Marvel",
            website = "Movie Hub",
            response = true,
            writer = "James",
            actors = "Chris Hemsworth"
        )

        //When

        val expectedMovieDetail = movieDetail(movieDetail)

        //Then
        assertEquals(
            expectedMovieDetail, movieDomain
        )
    }
}