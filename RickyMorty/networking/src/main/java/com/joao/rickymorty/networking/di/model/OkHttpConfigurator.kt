package com.joao.rickymorty.networking.di.model

import okhttp3.OkHttpClient

interface OkHttpConfigurator {

    fun configure(clientBuilder: OkHttpClient.Builder)

}