package com.example.mypokemonapp.data.entity.details

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class HeldItem(
    val item: Item,
    @SerializedName("version_details")
    val versionDetails: List<VersionDetail>,
) : Parcelable
