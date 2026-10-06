package com.pemmob.responsi1_fariz.data.model

data class PokemonListResponse(
    val count: Int,
    val next: String?,
    val results: List<PokemonResult>
)

data class PokemonResult (
    val name: String,
    val url: String
)