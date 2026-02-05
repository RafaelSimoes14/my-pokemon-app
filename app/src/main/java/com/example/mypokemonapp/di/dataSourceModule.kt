package com.example.mypokemonapp.di

import com.example.mypokemonapp.data.local.datasource.LocalDataSource
import com.example.mypokemonapp.data.remote.RemoteDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
}