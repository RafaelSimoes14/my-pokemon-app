package com.example.mypokemonapp.data.remote

import com.example.mypokemonapp.data.network.PokemonApi

class RemoteDataSource(
    private val pokemonApi: PokemonApi
) {
    suspend fun getPokemons() = pokemonApi.getPokemons()
    suspend fun getDetails(pokemon: String) = pokemonApi.getDetail(pokemon)
}