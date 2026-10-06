package com.pemmob.responsi1_fariz.data.repository

import com.pemmob.responsi1_fariz.data.model.Pokemon
import com.pemmob.responsi1_fariz.data.model.PokemonDetailResponse
import com.pemmob.responsi1_fariz.data.model.toPokemon
import com.pemmob.responsi1_fariz.data.api.PokeApiService
import com.pemmob.responsi1_fariz.data.api.RetrofitClient

class PokemonRepository(
    private val api: PokeApiService = RetrofitClient.api
) {
    suspend fun getPokemonList(): Result<List<Pokemon>> = runCatching {
        api.getPokemonList().results.map { it.toPokemon() }
    }

    suspend fun getPokemonDetail(name: String): Result<PokemonDetailResponse> = runCatching {
        api.getPokemonDetail(name)
    }
}
