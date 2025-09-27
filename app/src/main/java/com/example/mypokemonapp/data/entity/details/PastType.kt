package com.example.mypokemonapp.data.entity.details

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PastType(
    val generation: Generation,
    val types: List<TypeSlot>
) : Parcelable