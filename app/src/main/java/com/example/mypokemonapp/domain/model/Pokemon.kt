package com.example.mypokemonapp.domain.model

data class Pokemon(
    val id: Int,
    val name: String,
    val url: String,
    val detail: PokemonDetail? = null
)