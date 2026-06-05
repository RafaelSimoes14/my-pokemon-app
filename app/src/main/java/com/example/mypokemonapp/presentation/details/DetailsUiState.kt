package com.example.mypokemonapp.presentation.details

import com.example.mypokemonapp.domain.model.PokemonDetail

sealed interface DetailsUiState {

    object Loading : DetailsUiState

    data class Success(
        val pokemon: PokemonDetail
    ) : DetailsUiState

    data class Error(
        val cause: Throwable
    ) : DetailsUiState
}