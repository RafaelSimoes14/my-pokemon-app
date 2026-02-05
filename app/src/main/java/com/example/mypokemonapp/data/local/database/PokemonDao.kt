package com.example.mypokemonapp.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface PokemonDao {

    @Query("SELECT * FROM Pokemons")
    suspend fun getAll(): List<PokemonDB>

    @Query("SELECT * FROM Pokemons WHERE name = :name LIMIT 1")
    suspend fun getByName(name: String): PokemonDB?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pokemons: List<PokemonDB>)

    @Update
    suspend fun update(pokemon: PokemonDB)

    @Query("UPDATE Pokemons SET detail = :detailJson WHERE name = :name")
    suspend fun updateDetailByName(name: String, detailJson: String?)
}