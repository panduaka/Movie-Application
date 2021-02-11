package com.example.movieapp.di

import com.example.movieapp.data.MovieRepositoryImpl
import com.example.movieapp.domain.repository.MovieRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { MovieRepositoryImpl() as MovieRepository }
}