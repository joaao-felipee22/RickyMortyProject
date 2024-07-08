package com.joao.rickymorty.features.characters.list.domain.models

data class Character(
    val info: Info,
    val results: List<Result>
)
