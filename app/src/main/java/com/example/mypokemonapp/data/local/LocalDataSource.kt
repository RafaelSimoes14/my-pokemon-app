package com.example.mypokemonapp.data.local

import com.example.mypokemonapp.data.database.PokemonDB
import com.example.mypokemonapp.data.database.PokemonDao
import com.example.mypokemonapp.data.database.converter.toJson
import com.example.mypokemonapp.data.database.converter.toPokemonDetail
import com.example.mypokemonapp.data.entity.details.PokemonDetail
import com.example.mypokemonapp.data.entity.pokemons.Pokemon

class LocalDataSource(
    private val dao: PokemonDao?
) {

    suspend fun save(pokemons: List<Pokemon>): Boolean {
        return try {
            val dbPokemons: Array<PokemonDB> = pokemons.map { pokemon ->
                PokemonDB(id = pokemon.getId(), name = pokemon.name, url = pokemon.url)
            }.toTypedArray()
            dao?.insert(*dbPokemons)
            true
        } catch (t: Throwable) {
            false
        }
    }

    suspend fun get(): List<Pokemon> {
        return try {
            val dbPokemons = dao?.getAll()
            val pokemons: List<Pokemon>? = dbPokemons?.map { pokemonDB ->
                Pokemon(
                    name = pokemonDB.name,
                    url = pokemonDB.url,
                    detail = pokemonDB.detail?.toPokemonDetail()
                )
            }
            pokemons ?: listOf()
        } catch (t: Throwable) {
            t.printStackTrace()
            throw t
        }
    }

    suspend fun getDetail(pokemon: String): PokemonDetail? {
        return try {
            val dbPokemon = dao?.getBy(pokemon)
            dbPokemon?.detail?.toPokemonDetail()
        } catch (t: Throwable) {
            t.printStackTrace()
            throw t
        }
    }

    suspend fun saveDetail(pokemon: String, detail: PokemonDetail): Boolean {
        return try {
            val dbPokemon = dao?.getBy(pokemon) ?: return false
            dbPokemon.detail = detail.toJson()
            dao.update(dbPokemon)
            true
        } catch (t: Throwable) {
            t.printStackTrace()
            throw t
        }
    }
}