package com.example.mypokemonapp.data.mapper

import com.example.mypokemonapp.data.local.database.PokemonDB
import com.example.mypokemonapp.data.local.database.entity.PokemonAbilityEntity
import com.example.mypokemonapp.data.local.database.entity.PokemonDetailEntity
import com.example.mypokemonapp.data.local.database.entity.PokemonStatEntity
import com.example.mypokemonapp.domain.model.Pokemon
import com.example.mypokemonapp.domain.model.PokemonAbility
import com.example.mypokemonapp.domain.model.PokemonDetail
import com.example.mypokemonapp.domain.model.PokemonStat
import com.example.mypokemonapp.domain.model.PokemonType

object PokemonEntityMapper {

    fun toEntity(domain: Pokemon): PokemonDB {
        return PokemonDB(
            id = domain.id,
            name = domain.name,
            url = domain.url,
            detail = domain.detail?.let { toDetailEntity(it) }
        )
    }

    fun fromEntity(entity: PokemonDB): Pokemon {
        return Pokemon(
            id = entity.id,
            name = entity.name,
            url = entity.url,
            detail = entity.detail?.let { fromDetailEntity(it) }
        )
    }

    fun toDetailEntity(domain: PokemonDetail): PokemonDetailEntity {
        return PokemonDetailEntity(
            id = domain.id,
            name = domain.name,
            imageUrl = domain.imageUrl,
            height = domain.height,
            weight = domain.weight,
            types = domain.types.map { it.name },
            abilities = domain.abilities.map {
                PokemonAbilityEntity(name = it.name, isHidden = it.isHidden)
            },
            stats = domain.stats.map {
                PokemonStatEntity(name = it.name, value = it.value)
            }
        )
    }

    fun fromDetailEntity(entity: PokemonDetailEntity): PokemonDetail {
        return PokemonDetail(
            id = entity.id,
            name = entity.name,
            imageUrl = entity.imageUrl,
            height = entity.height,
            weight = entity.weight,
            types = entity.types.map { PokemonType(it) },
            abilities = entity.abilities.map {
                PokemonAbility(name = it.name, isHidden = it.isHidden)
            },
            stats = entity.stats.map {
                PokemonStat(name = it.name, value = it.value)
            }
        )
    }
}