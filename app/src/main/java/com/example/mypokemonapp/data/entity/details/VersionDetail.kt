package com.example.mypokemonapp.data.entity.details

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VersionDetail(
    val rarity: Long? = null,
    val version: Version2
) : Parcelable
