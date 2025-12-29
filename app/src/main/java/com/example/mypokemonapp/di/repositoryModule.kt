package com.example.mypokemonapp.di

import com.example.mypokemonapp.data.repository.PokemonRepository
import com.example.mypokemonapp.data.repository.PokemonRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<PokemonRepository> {
        PokemonRepositoryImpl(
            localDataSource = get(),
            remoteDataSource = get()
        )
    }
}