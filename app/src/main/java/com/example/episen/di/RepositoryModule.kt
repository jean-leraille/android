package com.example.episen.di

import com.example.episen.data.repositories.Repository
import org.koin.dsl.module

val RepositoryModule = module {
    single { Repository(retrofitClient = get()) }
}
