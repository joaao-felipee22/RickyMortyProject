package com.joao.rickymorty.features.characters.list.data.repository

import com.joao.rickymorty.features.characters.list.data.datasource.remote.CharactersRemoteDataSource
import com.joao.rickymorty.features.characters.list.data.mappers.toDomain
import com.joao.rickymorty.features.characters.list.domain.models.Character
import com.joao.rickymorty.features.characters.list.domain.repository.CharactersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(private val dataSource: CharactersRemoteDataSource) :
    CharactersRepository {
    override suspend fun getCharacters(): Flow<Character> {

        return flow {
            val characterResponse = dataSource.getResponseCharacter()
            val character = characterResponse.toDomain()
            emit(character)
        }
    }
}