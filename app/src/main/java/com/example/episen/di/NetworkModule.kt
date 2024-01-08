package com.example.episen.di

import com.example.episen.data.network.RetrofitClient
import org.koin.dsl.module

val NetworkModule = module {
    single { RetrofitClient() }
}