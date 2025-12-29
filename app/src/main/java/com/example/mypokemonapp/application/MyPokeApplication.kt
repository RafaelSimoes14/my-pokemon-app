package com.example.mypokemonapp.application

import android.app.Application
import com.example.mypokemonapp.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyPokeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyPokeApplication)
            modules(appModules)
        }
    }
}