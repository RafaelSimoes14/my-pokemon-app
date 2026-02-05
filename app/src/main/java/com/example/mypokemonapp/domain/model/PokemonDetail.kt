package com.example.mypokemonapp.domain.model

data class PokemonDetail(
    val id: Long,
    val name: String,
    val imageUrl: String,
    val height: Long?,
    val weight: Long?,
    val types: List<PokemonType>,
    val abilities: List<PokemonAbility>,
    val stats: List<PokemonStat>
)