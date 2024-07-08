package com.joao.rickymorty.features.characters.list.data.mappers

import com.joao.rickymorty.features.characters.list.data.datasource.remote.models.CharacterResponse
import com.joao.rickymorty.features.characters.list.data.datasource.remote.models.InfoResponse
import com.joao.rickymorty.features.characters.list.data.datasource.remote.models.LocationResponse
import com.joao.rickymorty.features.characters.list.data.datasource.remote.models.OriginResponse
import com.joao.rickymorty.features.characters.list.data.datasource.remote.models.ResultResponse
import com.joao.rickymorty.features.characters.list.domain.models.Character
import com.joao.rickymorty.features.characters.list.domain.models.Info
import com.joao.rickymorty.features.characters.list.domain.models.Location
import com.joao.rickymorty.features.characters.list.domain.models.Origin
import com.joao.rickymorty.features.characters.list.domain.models.Result as DomainResult

fun LocationResponse.toDomain() : Location {
    return Location(this.name, this.url)
}

fun OriginResponse.toDomain() : Origin {
    return Origin(this.name, this.url)
}

fun InfoResponse.toDomain() : Info {
    return Info(this.count, this.next, this.pages, this.prev)
}

fun ResultResponse.toDomain() : DomainResult {
    return DomainResult(this.created, this.episode, this.gender, this.id, this.image, this.location.toDomain(), this.name, this.origin.toDomain(), this.species, this.status, this.type, this.url)
}

fun CharacterResponse.toDomain() : Character {
    return Character(this.info.toDomain(), this.results.map { it.toDomain() })
}
