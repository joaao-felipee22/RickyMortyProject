package com.joao.rickymorty.features.characters.list.data.datasource.remote

import com.joao.rickymorty.features.characters.list.data.datasource.remote.models.CharacterResponse
import retrofit2.http.GET

interface CharacterService {
    @GET("character")
    suspend fun getResponseCharacter() : CharacterResponse
}