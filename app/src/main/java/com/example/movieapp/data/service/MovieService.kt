package com.example.movieapp.data.service

import com.example.movieapp.BuildConfig
import com.example.movieapp.data.model.Movie
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface MovieService {
    //Get function
    suspend fun getMovies(): Response<List<Movie>>

    companion object {
        fun create(): MovieService {
            val retrofitBuilder = Retrofit.Builder()
            retrofitBuilder.apply {
                baseUrl(BuildConfig.BASE_URL)
                client(getHttpClient())
                addConverterFactory(GsonConverterFactory.create())
            }
            return retrofitBuilder.build().create(MovieService::class.java)
        }


        private fun getHttpClient(): OkHttpClient {
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor { chain ->
                val original = chain.request()
                val originalHttpUrl = original.url()
                val url = originalHttpUrl.newBuilder()
                    .addQueryParameter("apikey", BuildConfig.API_KEY)
                    .build()

                // Request customization: add request headers
                val requestBuilder = original.newBuilder()
                    .url(url)
                val request = requestBuilder.build()
                chain.proceed(request)
            }
            return httpClient.build()
        }

    }
}