package com.example.mypokemonapp.di

import com.example.mypokemonapp.domain.BusinessUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory{ BusinessUseCase(get()) }
}