package com.joao.rickymorty.shared.mappers

interface Mapper<in Input : Any, Output : Any> {

    fun map(input: Input): Output
}