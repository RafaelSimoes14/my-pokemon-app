package com.example.mypokemonapp.data.local.converter

import androidx.room.TypeConverter
import com.example.mypokemonapp.data.local.database.entity.PokemonDetailEntity
import com.google.gson.Gson

class PokemonDetailEntityConverter(
    private val gson: Gson = Gson()
) {
    @TypeConverter
    fun fromString(value: String?): PokemonDetailEntity? {
        if (value.isNullOrBlank()) return null
        return gson.fromJson(value, PokemonDetailEntity::class.java)
    }

    @TypeConverter
    fun fromEntity(entity: PokemonDetailEntity?): String? {
        if (entity == null) return null
        return gson.toJson(entity)
    }
}