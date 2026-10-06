package com.pemmob.responsi1_fariz.data.model

import com.google.gson.annotations.SerializedName

data class PokemonDetailResponse(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<TypeSlot>,
    val stats: List<StatSlot>
)

data class TypeSlot(
    val slot: Int,
    val type: NamedResource
)
data class StatSlot(
    @SerializedName("base_stat") val baseStat: Int,
    val stat: NamedResource
)

data class NamedResource(
    val name: String
)