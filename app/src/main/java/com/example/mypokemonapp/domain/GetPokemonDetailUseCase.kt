package com.example.mypokemonapp.domain

import com.example.mypokemonapp.data.repository.PokemonRepository

class GetPokemonDetailUseCase(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(pokemonName: String) =
        repository.getPokemonDetails(pokemonName)
}