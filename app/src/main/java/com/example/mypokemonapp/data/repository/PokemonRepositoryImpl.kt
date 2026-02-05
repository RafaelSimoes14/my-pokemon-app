package com.example.mypokemonapp.data.repository

import com.example.mypokemonapp.data.local.datasource.LocalDataSource
import com.example.mypokemonapp.data.mapper.PokemonDtoMapper
import com.example.mypokemonapp.data.remote.RemoteDataSource
import com.example.mypokemonapp.domain.model.Pokemon
import com.example.mypokemonapp.domain.model.PokemonDetail
import com.example.mypokemonapp.domain.repository.PokemonRepository
import com.example.mypokemonapp.domain.result.Result

class PokemonRepositoryImpl(
    private val local: LocalDataSource,
    private val remote: RemoteDataSource
) : PokemonRepository {

    override suspend fun getPokemons(): Result<List<Pokemon>> {
        return try {
            val cached = local.getAllPokemons()
            if (cached.isNotEmpty()) {
                Result.Success(cached)
            } else {
                val response = remote.getPokemons()
                val domain = PokemonDtoMapper.fromGetPokemonsResponse(response)
                local.savePokemons(domain)
                Result.Success(domain)
            }
        } catch (t: Throwable) {
            Result.Error(t)
        }
    }

    override suspend fun getPokemonDetails(pokemonName: String): Result<PokemonDetail> {
        return try {
            val cached = local.getDetailByName(pokemonName)
            if (cached != null) {
                Result.Success(cached)
            } else {
                val response = remote.getDetails(pokemonName)
                val domain = PokemonDtoMapper.fromPokemonDetailResponse(response)
                local.saveDetail(pokemonName, domain)
                Result.Success(domain)
            }
        } catch (t: Throwable) {
            Result.Error(t)
        }
    }
}