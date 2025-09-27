package com.example.mypokemonapp.data.entity.details

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cries(
    val latest: String? = null,
    val legacy: String? = null
) : Parcelable
