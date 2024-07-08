package com.joao.rickymorty.features.characters.list.data.datasource.remote.models

data class InfoResponse(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)
