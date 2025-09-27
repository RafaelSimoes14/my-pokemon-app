package com.example.mypokemonapp.data.remote

import com.example.mypokemonapp.data.entity.details.PokemonDetail
import com.example.mypokemonapp.data.entity.pokemons.GetPokemons
import com.example.mypokemonapp.data.network.PokemonApi

class RemoteDataSource(
    private val pokemonApi: PokemonApi
) {

    suspend fun getPokemons(): GetPokemons {
        try {
            val data = pokemonApi.getPokemons()
            return data
        } catch (t: Throwable) {
            throw t
        }
    }

    suspend fun getDetails(pokemon: String): PokemonDetail {
        try {
            val data = pokemonApi.getDetail(pokemon)
            return data
        } catch (t: Throwable) {
            throw t
        }
    }
}