package com.example.mypokemonapp.domain

import com.example.mypokemonapp.data.repository.PokemonRepository

class GetPokemonsUseCase(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke() = repository.getPokemon()
}