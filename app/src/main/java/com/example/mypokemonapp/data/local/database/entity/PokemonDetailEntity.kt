package com.example.mypokemonapp.data.local.database.entity

data class PokemonDetailEntity(
    val id: Long,
    val name: String,
    val imageUrl: String,
    val height: Long?,
    val weight: Long?,
    val types: List<String>,
    val abilities: List<PokemonAbilityEntity>,
    val stats: List<PokemonStatEntity>
)