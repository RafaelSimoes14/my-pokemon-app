package com.example.mypokemonapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("Pokemons")
data class PokemonDB(
    @PrimaryKey
    val id: Int,
    val name: String,
    val url: String,
    var detail: String? = null
)