package com.example.mypokemonapp.data.entity.details

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Mfe(
    val move: Move,
    @SerializedName("version_group_details")
    val versionGroupDetails: List<VersionGroupDetail>
) : Parcelable
