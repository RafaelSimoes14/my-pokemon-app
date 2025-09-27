package com.example.mypokemonapp.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PokemonDao {
    @Query("SELECT * FROM Pokemons")
    suspend fun getAll(): List<PokemonDB>

    @Query("SELECT * FROM Pokemons WHERE name = :name")
    suspend fun getBy(name: String): PokemonDB

    @Insert
    suspend fun insert(vararg pokemons: PokemonDB)

    @Delete
    suspend fun delete(pokemon: PokemonDB)

    @Update
    suspend fun update(pokemon: PokemonDB)
}