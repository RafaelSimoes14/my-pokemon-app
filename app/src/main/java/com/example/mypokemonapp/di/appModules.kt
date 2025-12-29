package com.example.mypokemonapp.di

import org.koin.core.module.Module

val appModules: List<Module> = listOf(
    viewModelModule,
    useCaseModule,
    repositoryModule,
    dataSourceModule,
    databaseModule,
    networkModule
)