package com.example.mypokemonapp.data.local.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mypokemonapp.data.local.database.entity.PokemonDetailEntity

@Entity("Pokemons")
data class PokemonDB(
    @PrimaryKey
    val id: Int,
    val name: String,
    val url: String,
    var detail: PokemonDetailEntity? = null
)