package com.example.mypokemonapp.domain

import com.example.mypokemonapp.data.repository.MyPokemonRepository

class BusinessUseCase(
    private val repository: MyPokemonRepository
) {

    suspend fun getPokemon() = repository.getPokemon()
    suspend fun getDetails(id: String) = repository.getDetails(id)

}