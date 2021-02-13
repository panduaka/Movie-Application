package com.example.movieapp.di

import com.example.movieapp.ui.MainActivityViewModel
import com.example.movieapp.ui.MovieDetailActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainActivityViewModel(get()) }
    viewModel { MovieDetailActivityViewModel(get()) }
}