package com.joao.rickymorty.features.characters.list.presentation.models

import com.joao.rickymorty.features.characters.list.domain.models.Result

sealed class UiState {
    data object Loading : UiState()
    data object Error : UiState()
    data class Success(val results: List<Result>) : UiState()
    data object Empty : UiState()
}