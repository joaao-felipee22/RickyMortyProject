package com.joao.rickymorty.features.characters.list.data.datasource.remote.models

data class CharacterResponse(
    val info: InfoResponse,
    val results: List<ResultResponse>
)
