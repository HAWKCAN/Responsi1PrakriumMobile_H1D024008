package com.pemmob.responsi1_fariz.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.pemmob.responsi1_fariz.data.model.Pokemon
import com.pemmob.responsi1_fariz.data.model.capitalizeFirst
import com.pemmob.responsi1_fariz.data.model.toPokedexNumber

@Composable
fun PokemonCard(
    pokemon: Pokemon,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            Modifier.padding(12.dp).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = pokemon.imageUrl,
                contentDescription = pokemon.name,
                modifier = Modifier.size(110.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                pokemon.id.toPokedexNumber(),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                pokemon.name.capitalizeFirst(),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}
