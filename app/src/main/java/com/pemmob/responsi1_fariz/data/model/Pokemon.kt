package com.pemmob.responsi1_fariz.data.model

data class Pokemon(
    val id: Int,
    val name: String,
    val imageUrl: String
)

fun PokemonResult.toPokemon(): Pokemon {
    val id = url.trimEnd('/').substringAfterLast('/').toIntOrNull() ?: 0
    return Pokemon(
        id = id,
        name = name,
        imageUrl = spriteUrl(id)
    )
}

fun spriteUrl(id: Int): String =
    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"

fun String.capitalizeFirst(): String =
    replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }

fun Int.toPokedexNumber(): String = "#%03d".format(this)