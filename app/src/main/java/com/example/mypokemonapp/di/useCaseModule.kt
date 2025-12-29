package com.example.mypokemonapp.di

import com.example.mypokemonapp.domain.GetPokemonDetailUseCase
import com.example.mypokemonapp.domain.GetPokemonsUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetPokemonsUseCase(repository = get()) }
    factory { GetPokemonDetailUseCase(repository = get()) }
}