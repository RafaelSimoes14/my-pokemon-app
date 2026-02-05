package com.example.mypokemonapp.di

import com.example.mypokemonapp.data.repository.PokemonRepositoryImpl
import com.example.mypokemonapp.domain.repository.PokemonRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<PokemonRepository> {
        PokemonRepositoryImpl(
            local = get(),
            remote = get()
        )
    }
}