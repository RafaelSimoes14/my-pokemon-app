package com.example.mypokemonapp.data.entity.details

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Crystal(
    @SerializedName("back_default")
    val backDefault: String? = null,
    @SerializedName("back_shiny")
    val backShiny: String? = null,
    @SerializedName("back_shiny_transparent")
    val backShinyTransparent: String? = null,
    @SerializedName("back_transparent")
    val backTransparent: String? = null,
    @SerializedName("front_default")
    val frontDefault: String? = null,
    @SerializedName("front_shiny")
    val frontShiny: String? = null,
    @SerializedName("front_shiny_transparent")
    val frontShinyTransparent: String? = null,
    @SerializedName("front_transparent")
    val frontTransparent: String? = null,
) : Parcelable
