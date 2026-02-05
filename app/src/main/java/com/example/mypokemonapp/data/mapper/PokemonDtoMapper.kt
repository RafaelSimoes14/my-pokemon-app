package com.example.mypokemonapp.data.mapper

import com.example.mypokemonapp.data.entity.details.PokemonDetailResponse
import com.example.mypokemonapp.data.entity.pokemons.GetPokemonsResponse
import com.example.mypokemonapp.domain.model.Pokemon
import com.example.mypokemonapp.domain.model.PokemonAbility
import com.example.mypokemonapp.domain.model.PokemonDetail
import com.example.mypokemonapp.domain.model.PokemonStat
import com.example.mypokemonapp.domain.model.PokemonType

object PokemonDtoMapper {

    fun fromGetPokemonsResponse(response: GetPokemonsResponse): List<Pokemon> {
        return response.results.map { item ->
            Pokemon(
                id = extractId(item.url),
                name = item.name,
                url = item.url,
                detail = null
            )
        }
    }

    fun fromPokemonDetailResponse(response: PokemonDetailResponse): PokemonDetail {
        val id = response.id ?: error("PokemonDetailResponse.id is null")
        val name = response.name

        val imageUrl =
            response.sprites.other.officialArtwork?.frontDefault
                ?: response.sprites.frontDefault
                ?: ""

        val types = response.types.mapNotNull { it.type.name }
            .map { PokemonType(name = it) }

        val abilities = response.abilities.orEmpty().map {
            PokemonAbility(
                name = it.ability?.name.orEmpty(),
                isHidden = it.isHidden
            )
        }

        val stats = response.stats.map {
            PokemonStat(
                name = it.stat.name.orEmpty(),
                value = it.baseStat
            )
        }

        return PokemonDetail(
            id = id,
            name = name.replaceFirstChar { it.uppercase() },
            imageUrl = imageUrl,
            height = response.height,
            weight = response.weight,
            types = types,
            abilities = abilities,
            stats = stats
        )
    }

    private fun extractId(url: String): Int {
        return try {
            url.trimEnd('/').split("/").last().toInt()
        } catch (_: Throwable) {
            0
        }
    }
}