package com.example.mypokemonapp.data.entity.details

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VersionGroup(
    val name: String? = null,
    val url: String? = null
) : Parcelable
