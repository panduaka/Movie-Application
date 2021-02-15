package com.example.movieapp.data

import com.example.movieapp.data.mapper.movieDetail
import com.example.movieapp.data.mapper.searchMovies
import com.example.movieapp.data.model.MainObject
import com.example.movieapp.data.model.MovieDetail
import com.example.movieapp.data.model.Ratings
import com.example.movieapp.data.model.Search
import com.example.movieapp.data.service.MovieService
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class MovieRepositoryImplTest {
    private lateinit var movieService: MovieService
    private lateinit var movieRepositoryImpl: MovieRepositoryImpl

    @Before
    fun setUp() {
        movieService = mockk()
        movieRepositoryImpl = MovieRepositoryImpl(movieService)
    }

    @Test
    fun getMovies() = runBlocking {
        //Given
        val search = Search(
            title = "Thor",
            year = 2000,
            imdbID = "IMDB_Thor",
            type = "Marvel",
            poster = ""
        )

        val mainObject = MainObject(
            search = listOf(search),
            totalResults = 100,
            response = true
        )

        //When
        coEvery { movieService.getMovies("Thor") } returns Response.success(mainObject)

        val movieResponse = movieRepositoryImpl.getMovies("Thor") as com.example.movieapp.cleanarch.Response.Success

        //Then
        assertEquals(movieResponse.data, searchMovies(mainObject.search))
    }

    @Test
    fun getMovieDetail() = runBlocking {
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
            ratings = listOf(ratings),
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

        //When

        coEvery { movieService.getMovieDetail("IMDB") } returns Response.success(movieDetail)

        val movieResponse = movieRepositoryImpl.getMovieDetail("IMDB") as com.example.movieapp.cleanarch.Response.Success

        //Then
        assertEquals(movieResponse.data, movieDetail(movieDetail))
    }

    @After
    fun tearDown() {
        clearAllMocks(true)
    }

}