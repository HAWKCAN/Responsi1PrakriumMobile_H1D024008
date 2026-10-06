package com.pemmob.responsi1_fariz.ui.components

import androidx.compose.material3.AssistChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.pemmob.responsi1_fariz.data.model.capitalizeFirst

@Composable
fun TypeChip(type: String) {
    AssistChip(onClick = {}, label = { Text(type.capitalizeFirst()) })
}
