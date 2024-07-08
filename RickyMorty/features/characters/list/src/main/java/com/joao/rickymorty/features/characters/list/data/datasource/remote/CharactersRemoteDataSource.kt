package com.joao.rickymorty.features.characters.list.data.datasource.remote

import com.joao.rickymorty.features.characters.list.data.datasource.remote.models.CharacterResponse

interface CharactersRemoteDataSource {
    suspend fun getResponseCharacter() : CharacterResponse
}