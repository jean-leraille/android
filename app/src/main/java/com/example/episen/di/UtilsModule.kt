package com.example.episen.di

import android.content.Context
import android.content.SharedPreferences
import com.example.episen.utils.SharedPreferencesHelper
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val UtilsModule = module {
    single {
        getSharedPrefs(androidContext())
    }

    single<SharedPreferences.Editor> {
        getSharedPrefs(androidContext()).edit()
    }

    single { SharedPreferencesHelper(get()) }
}

fun getSharedPrefs(context: Context): SharedPreferences {
    return context.getSharedPreferences("default", Context.MODE_PRIVATE)
}