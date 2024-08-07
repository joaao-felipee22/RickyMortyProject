package com.joao.rickymorty.features.characters.list.di

import com.joao.rickymorty.features.characters.list.data.datasource.remote.CharacterService
import com.joao.rickymorty.features.characters.list.data.datasource.remote.CharactersRemoteDataSource
import com.joao.rickymorty.features.characters.list.data.datasource.remote.CharactersRemoteDataSourceImpl
import com.joao.rickymorty.features.characters.list.data.repository.CharactersRepositoryImpl
import com.joao.rickymorty.features.characters.list.domain.repository.CharactersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object CharactersListModule {

    @Provides
    @ViewModelScoped
    fun bindCharacterRepository(dataSource: CharactersRemoteDataSource) : CharactersRepository {
        return CharactersRepositoryImpl(dataSource)
    }

//    @Binds
//    @Singleton
//    fun bindMapper() : Mapper<CharacterResponse, Character>{
//        return
//    }
}