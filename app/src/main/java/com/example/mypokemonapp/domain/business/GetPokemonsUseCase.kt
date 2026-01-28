package com.example.mypokemonapp.domain.business

import com.example.mypokemonapp.domain.repository.PokemonRepository

class GetPokemonsUseCase(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke() = repository.getPokemon()
}