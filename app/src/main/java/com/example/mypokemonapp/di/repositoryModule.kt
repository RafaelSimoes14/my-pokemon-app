package com.example.mypokemonapp.di

import com.example.mypokemonapp.data.repository.MyPokemonRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { MyPokemonRepository(get(), get()) }
}