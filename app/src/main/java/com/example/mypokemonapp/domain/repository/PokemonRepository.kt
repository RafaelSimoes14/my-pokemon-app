package com.example.mypokemonapp.domain.repository

import com.example.mypokemonapp.domain.model.Pokemon
import com.example.mypokemonapp.domain.model.PokemonDetail
import com.example.mypokemonapp.domain.result.Result

interface PokemonRepository {
    suspend fun getPokemons(): Result<List<Pokemon>>
    suspend fun getPokemonDetails(pokemonName: String): Result<PokemonDetail>
}