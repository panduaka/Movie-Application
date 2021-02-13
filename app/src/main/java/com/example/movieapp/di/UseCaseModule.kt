package com.example.movieapp.di

import com.example.movieapp.domain.interactors.GetMovieDetailUseCase
import com.example.movieapp.domain.interactors.GetMoviesUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetMoviesUseCase(get()) }
    factory { GetMovieDetailUseCase(get()) }
}