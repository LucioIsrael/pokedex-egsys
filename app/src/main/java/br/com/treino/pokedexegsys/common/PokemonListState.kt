package br.com.treino.pokedexegsys.common

import br.com.treino.pokedexegsys.api.model.PokemonsListResponse

data class PokemonListState(
    val isLoading: Boolean = false,
    val pokemonsList: PokemonsListResponse = PokemonsListResponse(results = emptyList(), count = 0),
    val error: String = ""
)
