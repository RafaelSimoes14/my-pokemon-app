package com.example.mypokemonapp.data.entity.details

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Stat(
    @SerializedName("base_stat")
    val baseStat: Long? = null,
    val effort: Long? = null,
    val stat: Stat2
) : Parcelable
