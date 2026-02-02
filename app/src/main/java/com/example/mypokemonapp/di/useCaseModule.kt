package com.example.mypokemonapp.di

import com.example.mypokemonapp.domain.usecase.GetPokemonDetailUseCase
import com.example.mypokemonapp.domain.usecase.GetPokemonsUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetPokemonsUseCase(repository = get()) }
    factory { GetPokemonDetailUseCase(repository = get()) }
}