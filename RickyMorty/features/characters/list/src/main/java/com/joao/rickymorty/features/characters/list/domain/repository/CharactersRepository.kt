package com.joao.rickymorty.features.characters.list.domain.repository

import com.joao.rickymorty.features.characters.list.domain.models.Character
import kotlinx.coroutines.flow.Flow


interface CharactersRepository {
    suspend fun getCharacters() : Flow<Character>
}