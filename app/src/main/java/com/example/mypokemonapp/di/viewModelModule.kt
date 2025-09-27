package com.example.mypokemonapp.di

import com.example.mypokemonapp.presentation.details.DetailsViewModel
import com.example.mypokemonapp.presentation.pokemons.PokemonsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{ PokemonsViewModel(get()) }
    viewModel{ DetailsViewModel(get()) }
}