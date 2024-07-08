package com.joao.rickymorty.features.characters.list.data.datasource.remote

import com.joao.rickymorty.features.characters.list.data.datasource.remote.models.CharacterResponse
import javax.inject.Inject

class CharactersRemoteDataSourceImpl @Inject constructor(private val service: CharacterService) : CharactersRemoteDataSource{

    override suspend fun getResponseCharacter(): CharacterResponse {
        return service.getResponseCharacter()
    }

}