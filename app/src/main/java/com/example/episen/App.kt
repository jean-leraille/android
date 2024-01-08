package com.example.episen

import android.app.Application
import com.example.episen.di.NetworkModule
import com.example.episen.di.RepositoryModule
import com.example.episen.di.UtilsModule
import com.example.episen.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application()  {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            //androidLogger()
            androidContext(this@App)
            modules(
                listOf(
                    ViewModelModule,
                    NetworkModule,
                    RepositoryModule,
                    UtilsModule
                )
            )
        }
    }
}