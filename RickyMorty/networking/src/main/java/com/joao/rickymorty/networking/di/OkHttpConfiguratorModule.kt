package com.joao.rickymorty.networking.di

import com.joao.rickymorty.networking.di.model.OkHttpConfigurator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OkHttpConfiguratorModule {

    const val TIMEOUT = 30L

    @Provides
    @Singleton
    fun provideOkHttpConfigurator() = object : OkHttpConfigurator {
        override fun configure(clientBuilder: OkHttpClient.Builder) {
            clientBuilder.callTimeout(TIMEOUT, TimeUnit.SECONDS)
        }
    }

}