package com.pemmob.responsi1_fariz.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pemmob.responsi1_fariz.data.model.Pokemon
import com.pemmob.responsi1_fariz.data.repository.PokemonRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: PokemonRepository = PokemonRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    // Daftar hasil filter: otomatis dihitung ulang saat data atau query berubah
    val filteredPokemon: StateFlow<List<Pokemon>> =
        combine(_uiState, _searchQuery) { state, query ->
            if (state is HomeUiState.Success) {
                state.pokemon.filter { it.name.contains(query.trim(), ignoreCase = true) }
            } else emptyList()
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    init { loadPokemon() }

    fun loadPokemon() {
        viewModelScope.launch {
            _uiState.value = HomeUiState.Loading
            repository.getPokemonList()
                .onSuccess { _uiState.value = HomeUiState.Success(it) }
                .onFailure { _uiState.value = HomeUiState.Error(it.message ?: "Terjadi kesalahan") }
        }
    }

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
    }
}
