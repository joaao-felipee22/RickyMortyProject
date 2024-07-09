package com.joao.rickymorty.features.characters.list.data.repository

import com.joao.rickymorty.features.characters.list.data.datasource.remote.CharactersRemoteDataSource
import com.joao.rickymorty.features.characters.list.data.datasource.remote.models.CharacterResponse
import com.joao.rickymorty.features.characters.list.data.datasource.remote.models.InfoResponse
import com.joao.rickymorty.features.characters.list.data.mappers.toDomain
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.doThrow
import org.mockito.kotlin.mock

class CharactersRepositoryImplTest {

    val fakeResponse = CharacterResponse(InfoResponse(1, "1", 1, "1"), listOf())
    @Test
    fun callGetCharacter_ReturnsFlowCharacter() = runTest{

        //Given
        val mockRemoteDataSource = mock<CharactersRemoteDataSource> {
            onBlocking { getResponseCharacter() } doReturn fakeResponse
        }
        val repository = CharactersRepositoryImpl(mockRemoteDataSource)


        //When
        val flow = repository.getCharacters()
        val character = flow.first()

        //Then
        assertEquals(character, fakeResponse.toDomain())
    }

    @Test(expected = Exception::class)
    fun callGetCharacter_ThrowsExpection() = runTest {
        val mockRemoteDataSource = mock<CharactersRemoteDataSource> {
            onBlocking { getResponseCharacter() } doThrow Exception()
        }

        val repository = CharactersRepositoryImpl(mockRemoteDataSource)
        
        //When
        repository.getCharacters()

    }

}