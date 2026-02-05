package com.example.mypokemonapp.data.entity.pokemons

import android.os.Parcelable
import com.example.mypokemonapp.data.entity.details.PokemonDetailResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonItemResponse(
    val name: String,
    val url: String,
    val detail: PokemonDetailResponse?
) : Parcelable