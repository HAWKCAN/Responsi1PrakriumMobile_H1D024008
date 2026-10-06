package com.pemmob.responsi1_fariz.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pemmob.responsi1_fariz.data.model.capitalizeFirst

@Composable
fun StatBar(name: String, value: Int, maxValue: Int = 255) {
    Row(
        Modifier.fillMaxWidth().padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(name.capitalizeFirst(), Modifier.width(110.dp), style = MaterialTheme.typography.bodyMedium)
        Text(value.toString(), Modifier.width(40.dp), style = MaterialTheme.typography.labelLarge)
        LinearProgressIndicator(
            progress = { (value.toFloat() / maxValue).coerceIn(0f, 1f) },
            modifier = Modifier.weight(1f)
        )
    }
}
