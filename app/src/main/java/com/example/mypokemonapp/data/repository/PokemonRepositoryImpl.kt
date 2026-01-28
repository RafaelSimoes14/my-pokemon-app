package com.example.mypokemonapp.data.repository

import com.example.mypokemonapp.data.entity.details.PokemonDetail
import com.example.mypokemonapp.data.entity.pokemons.Pokemon
import com.example.mypokemonapp.data.local.LocalDataSource
import com.example.mypokemonapp.data.remote.RemoteDataSource
import com.example.mypokemonapp.domain.repository.PokemonRepository
import com.example.mypokemonapp.util.state.Result

class PokemonRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : PokemonRepository {

    override suspend fun getPokemon(): Result<List<Pokemon>> {
        return try {
            val pokemonDB = localDataSource.get()
            if (pokemonDB.isNotEmpty()) {
                Result.Success(pokemonDB)
            } else {
                val pokemonAPI = remoteDataSource.getPokemons().results
                localDataSource.save(pokemonAPI)
                Result.Success(pokemonAPI)
            }
        } catch (t: Throwable) {
            Result.Error(t)
        }
    }

    override suspend fun getPokemonDetails(pokemonName: String): Result<PokemonDetail> {
        return try {
            val pokemonDBDetail: PokemonDetail? = localDataSource.getDetail(pokemonName)
            if (pokemonDBDetail != null) {
                Result.Success(pokemonDBDetail)
            } else {
                val pokemonAPIDetail = remoteDataSource.getDetails(pokemonName)
                localDataSource.saveDetail(pokemonName, pokemonAPIDetail)
                Result.Success(pokemonAPIDetail)
            }
        } catch (t: Throwable) {
            Result.Error(t)
        }
    }
}