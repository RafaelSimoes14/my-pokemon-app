package com.example.mypokemonapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mypokemonapp.data.database.converter.PokemonDetailsConverter

@Database(entities = [PokemonDB::class], version = 1)
@TypeConverters(PokemonDetailsConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}