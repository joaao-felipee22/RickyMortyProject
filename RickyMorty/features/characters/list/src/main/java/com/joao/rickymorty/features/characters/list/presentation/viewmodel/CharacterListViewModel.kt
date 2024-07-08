package com.joao.rickymorty.features.characters.list.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joao.rickymorty.features.characters.list.domain.models.Character
import com.joao.rickymorty.features.characters.list.domain.repository.CharactersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(private val repository: CharactersRepository): ViewModel() {

    val listFlowResult = MutableStateFlow<Character?>(null)
    fun getAllCharacters () {
        viewModelScope.launch{
            repository.getCharacters().collect{
                listFlowResult.emit(it)
            }
        }
    }
}