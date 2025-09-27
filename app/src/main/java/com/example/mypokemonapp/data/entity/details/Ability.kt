package com.example.mypokemonapp.data.entity.details

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ability(
    val ability: Ability2?,
    @SerializedName("is_hidden")
    val isHidden: Boolean,
    val slot: Long? = null
) : Parcelable
