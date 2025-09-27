package com.example.mypokemonapp.data.entity.details

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Type(
    val slot: Long? = null,
    val type: Type2
) : Parcelable
