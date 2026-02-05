package com.example.mypokemonapp.data.entity.pokemons

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GetPokemonsResponse(
    val count: Long,
    val next: String?,
    val previous: String?,
    val results: List<PokemonItemResponse>
) : Parcelable