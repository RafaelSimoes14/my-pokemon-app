package com.example.mypokemonapp.data.entity.details

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TypeSlot(
    val slot: Int,
    val type: TypeInfo
) : Parcelable