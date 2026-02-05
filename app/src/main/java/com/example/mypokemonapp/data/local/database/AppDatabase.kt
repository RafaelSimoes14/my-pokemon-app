package com.example.mypokemonapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mypokemonapp.data.local.converter.PokemonDetailEntityConverter

@Database(
    entities = [PokemonDB::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(PokemonDetailEntityConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}