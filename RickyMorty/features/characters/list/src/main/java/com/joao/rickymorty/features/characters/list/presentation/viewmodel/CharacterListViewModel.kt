package com.joao.rickymorty.features.characters.list.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joao.rickymorty.features.characters.list.domain.models.Character
import com.joao.rickymorty.features.characters.list.domain.repository.CharactersRepository
import com.joao.rickymorty.features.characters.list.presentation.models.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(private val repository: CharactersRepository): ViewModel() {

    private val _state = MutableStateFlow<UiState>(UiState.Loading)
    val state = _state.asStateFlow()
    fun getAllCharacters () {
        viewModelScope.launch{
            _state.value = UiState.Loading
            repository.getCharacters().catch {
                _state.value = UiState.Error
            }.collect{
                val results = it.results
                _state.value = if (results.isEmpty()) UiState.Empty else UiState.Success(results)
            }
        }
    }
}