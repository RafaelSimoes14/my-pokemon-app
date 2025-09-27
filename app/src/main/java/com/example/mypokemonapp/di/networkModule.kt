package com.example.mypokemonapp.di

import com.example.mypokemonapp.data.network.NetworkProvider
import org.koin.dsl.module

val networkModule = module {
    single { NetworkProvider.providePokemonApi() }
}