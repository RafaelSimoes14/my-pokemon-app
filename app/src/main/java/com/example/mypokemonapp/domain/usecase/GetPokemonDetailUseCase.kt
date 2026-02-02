package com.example.mypokemonapp.domain.usecase

import com.example.mypokemonapp.domain.repository.PokemonRepository

class GetPokemonDetailUseCase(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(pokemonName: String) =
        repository.getPokemonDetails(pokemonName)
}