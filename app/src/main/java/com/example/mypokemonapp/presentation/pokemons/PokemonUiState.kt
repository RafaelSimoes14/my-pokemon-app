package com.example.mypokemonapp.presentation.pokemons

import com.example.mypokemonapp.domain.model.Pokemon

sealed interface PokemonUiState {

    object Loading : PokemonUiState

    data class Success(
        val pokemons: List<Pokemon>
    ) : PokemonUiState

    object Empty : PokemonUiState

    data class Error(
        val cause: Throwable
    ) : PokemonUiState
}