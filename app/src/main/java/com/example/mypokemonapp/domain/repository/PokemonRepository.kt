package com.example.mypokemonapp.domain.repository

import com.example.mypokemonapp.data.entity.details.PokemonDetail
import com.example.mypokemonapp.data.entity.pokemons.Pokemon
import com.example.mypokemonapp.util.state.Result

interface PokemonRepository {
    suspend fun getPokemon(): Result<List<Pokemon>>
    suspend fun getPokemonDetails(pokemonName: String): Result<PokemonDetail>
}