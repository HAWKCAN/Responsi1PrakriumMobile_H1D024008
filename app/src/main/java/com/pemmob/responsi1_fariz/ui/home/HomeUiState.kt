package com.pemmob.responsi1_fariz.ui.home

import com.pemmob.responsi1_fariz.data.model.Pokemon

sealed interface HomeUiState {
    data object Loading : HomeUiState
    data class Success(val pokemon: List<Pokemon>) : HomeUiState
    data class Error(val message: String) : HomeUiState
}