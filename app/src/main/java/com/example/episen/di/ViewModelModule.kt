package com.example.episen.di

import com.example.episen.ViewModelFactory
import com.example.episen.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module {

    single {
        ViewModelFactory(
            repository = get(),
            sharedPreferenceHelper = get()
        )
    }

    viewModel { HomeViewModel(repository = get(), sharedPreferences = get()) }
}