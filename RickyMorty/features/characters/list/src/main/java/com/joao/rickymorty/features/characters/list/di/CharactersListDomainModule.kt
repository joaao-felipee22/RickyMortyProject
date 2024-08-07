package com.joao.rickymorty.features.characters.list.di

import com.joao.rickymorty.features.characters.list.data.datasource.remote.CharacterService
import com.joao.rickymorty.features.characters.list.data.datasource.remote.CharactersRemoteDataSource
import com.joao.rickymorty.features.characters.list.data.datasource.remote.CharactersRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CharactersListDomainModule {

    @Provides
    @Singleton
    fun provideCharacterService(retrofit: Retrofit) : CharacterService {
        return retrofit.create(CharacterService::class.java)
    }

    @Provides
    @Singleton
    fun bindRemoteDataSource(service: CharacterService) : CharactersRemoteDataSource {
        return CharactersRemoteDataSourceImpl(service)
    }
}