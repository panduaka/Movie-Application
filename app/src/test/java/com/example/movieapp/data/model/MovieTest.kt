package com.example.movieapp.data.model

import io.mockk.mockk
import org.junit.Assert.*
import org.junit.Test

class MovieTest {
    @Test
    fun getMainObjectTest() {
        //Given
        val listSearch = mockk<List<Search>>()
        //When
        val mainObject = MainObject(search = listSearch, totalResults = 100, response = true)
        //Then
        assertEquals(mainObject.search, listSearch)
    }

    @Test
    fun getSearchTest() {
        //Given

        val title = "Test title"
        val year = 2000
        val imdbID = "Test Imdb"
        val type = "Test type"
        val poster = "Test url"

        //When
        val search = Search(
            title = title,
            year = year,
            imdbID = imdbID,
            type = type,
            poster = poster
        )

        //Then
        assertEquals(title, search.title)
        assertEquals(year, search.year)
        assertEquals(imdbID, search.imdbID)
        assertEquals(type, search.type)
        assertEquals(poster, search.poster)

    }

    @Test
    fun getMovieDetailTest() {
        //Given

        val title = "Thor"
        val year = 2000
        val imdbID = "IMDB_Thor"
        val type = "Marvel"
        val released = "2001"
        val poster = "URL"
        val rated = "rated"
        val genre = "Action Thriller"
        val runtime = "2hours"
        val director = "James"
        val plot = "Plot"
        val language = "English"
        val country = "USA"
        val awards = "Oscar"
        val ratings = mockk<Ratings>()
        val metascore = 10
        val imdbRating = 7.8
        val imdbVotes = "234"
        val dVD = "DVD"
        val boxOffice = "Box Office"
        val production = "Marvel"
        val website = "Movie Hub"
        val response = true
        val writer = "James"
        val actors = "Chris Hemsworth"

        //When
        val movieDetail = MovieDetail(
            title = title,
            year = year,
            imdbID = imdbID,
            type = type,
            poster = poster,
            released = released,
            rated = rated,
            genre = genre,
            runtime = runtime,
            director = director,
            plot = plot,
            language = language,
            country = country,
            awards = awards,
            ratings = listOf<Ratings>(ratings),
            metascore = metascore,
            imdbRating = imdbRating,
            imdbVotes = imdbVotes,
            dVD = dVD,
            boxOffice = boxOffice,
            production = production,
            website = website,
            response = response,
            writer = writer,
            actors = actors
        )

        //Then
        assertEquals(title, movieDetail.title)
        assertEquals(listOf(ratings), movieDetail.ratings)
        assertEquals(imdbID, movieDetail.imdbID)
        assertEquals(type, movieDetail.type)
        assertEquals(poster, movieDetail.poster)

    }

}