package com.example.mypokemonapp.data.database.converter

import androidx.room.TypeConverter
import com.example.mypokemonapp.data.entity.details.PokemonDetail
import com.google.gson.Gson

class PokemonDetailsConverter {
    @TypeConverter
    fun fromString(value: String): PokemonDetail = value.toPokemonDetail()

    @TypeConverter
    fun fromPokemonDetail(detail: PokemonDetail): String = detail.toJson()
}

fun PokemonDetail.toJson(): String = Gson().toJson(this)
fun String.toPokemonDetail(): PokemonDetail = Gson().fromJson(this, PokemonDetail::class.java)