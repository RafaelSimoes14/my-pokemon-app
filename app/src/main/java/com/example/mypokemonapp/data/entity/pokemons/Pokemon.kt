package com.example.mypokemonapp.data.entity.pokemons

import android.os.Parcelable
import com.example.mypokemonapp.data.entity.details.PokemonDetail
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    val name: String,
    val url: String,
    val detail: PokemonDetail?
) : Parcelable {

    fun getId(): Int = try {
        url.split("/")[6].toInt()
    } catch (t: Throwable) {
        0
    }
}