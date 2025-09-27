package com.example.mypokemonapp.data.entity.details

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Index(
    @SerializedName("game_index")
    val gameIndex: Long? = null,
    val version: Version,
) : Parcelable
