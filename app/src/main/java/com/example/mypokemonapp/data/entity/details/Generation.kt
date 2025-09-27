package com.example.mypokemonapp.data.entity.details

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Generation(
    val name: String,
    val url: String
) : Parcelable