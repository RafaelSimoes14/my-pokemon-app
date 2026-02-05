package com.example.mypokemonapp.data.local.datasource

import com.example.mypokemonapp.data.local.database.PokemonDao
import com.example.mypokemonapp.data.mapper.PokemonEntityMapper
import com.example.mypokemonapp.domain.model.Pokemon
import com.example.mypokemonapp.domain.model.PokemonDetail

class LocalDataSource(
    private val dao: PokemonDao
) {
    suspend fun getAllPokemons(): List<Pokemon> {
        return dao.getAll().map(PokemonEntityMapper::fromEntity)
    }

    suspend fun savePokemons(pokemons: List<Pokemon>) {
        val entities = pokemons.map(PokemonEntityMapper::toEntity)
        dao.insertAll(entities)
    }

    suspend fun getDetailByName(name: String): PokemonDetail? {
        return dao.getByName(name)?.detail?.let(PokemonEntityMapper::fromDetailEntity)
    }

    suspend fun saveDetail(name: String, detail: PokemonDetail) {
        val entityDetail = PokemonEntityMapper.toDetailEntity(detail)
        // como o DAO já tem updateDetailByName(String), ele espera JSON.
        // MAIS LIMPO seria o DAO atualizar o objeto direto, mas o Room precisa do converter.
        // Solução prática: buscar entity, setar detail, update.
        val pokemon = dao.getByName(name) ?: return
        dao.update(pokemon.copy(detail = entityDetail))
    }
}