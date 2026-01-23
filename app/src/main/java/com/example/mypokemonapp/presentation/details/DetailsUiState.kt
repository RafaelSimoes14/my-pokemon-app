package com.example.mypokemonapp.presentation.details

import com.example.mypokemonapp.data.entity.details.PokemonDetail
import com.example.mypokemonapp.util.state.Result

sealed interface DetailsUiState {

    object Loading : DetailsUiState

    data class Success(
        val pokemon: Result<PokemonDetail>
    ) : DetailsUiState

    data class Error(
        val cause: String
    ) : DetailsUiState
}