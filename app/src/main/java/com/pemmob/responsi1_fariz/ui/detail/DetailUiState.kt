package com.pemmob.responsi1_fariz.ui.detail


import com.pemmob.responsi1_fariz.data.model.PokemonDetailResponse

sealed interface DetailUiState {
    data object Loading : DetailUiState
    data class Success(val detail: PokemonDetailResponse) : DetailUiState
    data class Error(val message: String) : DetailUiState
}
