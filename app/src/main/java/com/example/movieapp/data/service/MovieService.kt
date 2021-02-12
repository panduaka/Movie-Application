package com.example.movieapp.data.service

import android.util.Log
import com.example.movieapp.BuildConfig
import com.example.movieapp.data.model.MainObject
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("?type=movie")
    suspend fun getMovies(@Query("s") title: String): Response<MainObject>

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

                val requestBuilder = original.newBuilder()
                    .url(url)
                Log.d("URL", url.toString())
                val request = requestBuilder.build()
                chain.proceed(request)
            }
            return httpClient.build()
        }

    }
}