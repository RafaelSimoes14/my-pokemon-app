package com.example.mypokemonapp.data.repository

import com.example.mypokemonapp.util.state.Result
import com.example.mypokemonapp.data.entity.details.PokemonDetail
import com.example.mypokemonapp.data.entity.pokemons.Pokemon
import com.example.mypokemonapp.data.local.LocalDataSource
import com.example.mypokemonapp.data.remote.RemoteDataSource

class MyPokemonRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {

    suspend fun getPokemon(): Result<List<Pokemon>> {
        try {
            val pokemonDB = localDataSource.get()
            if (pokemonDB.isEmpty()) {
                val pokemonAPI = remoteDataSource.getPokemons().results
                localDataSource.save(pokemonAPI)
                return Result.Success(pokemonAPI)
            }

            return Result.Success(pokemonDB)

        } catch (t: Throwable) {
            return Result.Error(t)
        }
    }

    suspend fun getDetails(pokemon: String): Result<PokemonDetail> {
        try {
            val pokemonDBDetail: PokemonDetail? = localDataSource.getDetail(pokemon)
            if (pokemonDBDetail == null) {
                val pokemonAPIDetail = remoteDataSource.getDetails(pokemon)
                localDataSource.saveDetail(pokemon, pokemonAPIDetail)
                return Result.Success(pokemonAPIDetail)
            }

            return Result.Success(pokemonDBDetail)

        } catch (t: Throwable) {
            return Result.Error(t)
        }
    }
}