package com.example.mypokemonapp.data.network

import com.example.mypokemonapp.data.PokemonRules
import com.example.mypokemonapp.data.entity.details.PokemonDetailResponse
import com.example.mypokemonapp.data.entity.pokemons.GetPokemonsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {
    @GET("pokemon")
    suspend fun getPokemons(
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = PokemonRules.TOTAL
    ): GetPokemonsResponse

    @GET("pokemon/{name}")
    suspend fun getDetail(
        @Path("name") name: String
    ): PokemonDetailResponse
}