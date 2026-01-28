package com.example.mypokemonapp.presentation.details

import com.example.mypokemonapp.data.entity.details.PokemonDetail

sealed interface DetailsUiState {

    object Loading : DetailsUiState

    data class Success(
        val pokemon: PokemonDetail
    ) : DetailsUiState

    object Empty : DetailsUiState

    data class Error(
        val cause: Throwable
    ) : DetailsUiState
}