package com.example.mypokemonapp.data.entity.details

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GenerationIi(
    val crystal: Crystal,
    val gold: Gold,
    val silver: Silver,
) : Parcelable
