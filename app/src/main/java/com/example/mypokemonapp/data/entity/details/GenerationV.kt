package com.example.mypokemonapp.data.entity.details

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GenerationV(
    @SerializedName("black-white")
    val blackWhite: BlackWhite,
) : Parcelable
