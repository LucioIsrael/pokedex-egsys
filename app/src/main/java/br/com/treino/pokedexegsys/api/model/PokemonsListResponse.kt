package br.com.treino.pokedexegsys.api.model

import br.com.treino.pokedexegsys.api.dto.Result

data class PokemonsListResponse(
    val count: Int,
    val results: List<Result>
)
