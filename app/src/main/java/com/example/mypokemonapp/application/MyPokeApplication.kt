package com.example.mypokemonapp.application

import android.app.Application
import com.example.mypokemonapp.di.dataSourceModule
import com.example.mypokemonapp.di.databaseModule
import com.example.mypokemonapp.di.networkModule
import com.example.mypokemonapp.di.repositoryModule
import com.example.mypokemonapp.di.useCaseModule
import com.example.mypokemonapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyPokeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyPokeApplication)
            modules(
                viewModelModule,
                useCaseModule,
                repositoryModule,
                dataSourceModule,
                databaseModule,
                networkModule
            )
        }
    }
}