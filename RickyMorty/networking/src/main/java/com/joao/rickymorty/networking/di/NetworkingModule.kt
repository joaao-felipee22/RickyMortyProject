package com.joao.rickymorty.networking.di

import android.content.Context
import com.google.gson.Gson
import com.joao.rickymorty.networking.R
import com.joao.rickymorty.networking.di.model.OkHttpConfigurator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [OkHttpConfiguratorModule::class])
@InstallIn(SingletonComponent::class)
object NetworkingModule {

    @Provides
    @Singleton
    fun provideOkHttp(
        configurator: OkHttpConfigurator,
    ): OkHttpClient {
        val interceptor = provideLogger()

        return OkHttpClient.Builder()
            .apply { configurator.configure(this) }
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        @ApplicationContext context: Context,
        okHttpClient: OkHttpClient
    ): Retrofit {
        val baseUrl = context.getString(R.string.base_url)

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun provideLogger(debuggable: Boolean = true): Interceptor {
        val loggingLevel = if (debuggable) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return HttpLoggingInterceptor().apply { level = loggingLevel }
    }
}
