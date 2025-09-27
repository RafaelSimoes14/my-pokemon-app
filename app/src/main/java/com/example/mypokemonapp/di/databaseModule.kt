package com.example.mypokemonapp.di

import android.app.Application
import androidx.room.Room
import com.example.mypokemonapp.data.database.AppDatabase
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            get<Application>(),
            AppDatabase::class.java,
            "pokemon_database"
        ).build()
    }

    single { get<AppDatabase>().pokemonDao() }
}