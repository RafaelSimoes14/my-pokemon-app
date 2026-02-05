package com.example.mypokemonapp.data.entity.details

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonDetailResponse(
    val abilities: List<Ability>?,
    @SerializedName("base_experience")
    val baseExperience: Long? = null,
    val cries: Cries,
    val forms: List<Form>,
    @SerializedName("game_indices")
    val gameIndices: List<Index>,
    val height: Long? = null,
    @SerializedName("held_items")
    val heldItems: List<HeldItem>,
    val id: Long? = null,
    @SerializedName("is_default")
    val isDefault: Boolean,
    @SerializedName("location_area_encounters")
    val locationAreaEncounters: String? = null,
    val moves: List<Mfe>,
    val name: String,
    val order: Long? = null,
    @SerializedName("past_abilities")
    val pastAbilities: List<Ability>? = null,
    @SerializedName("past_types")
    val pastTypes: List<PastType>,
    val species: Species,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Long? = null,
) : Parcelable