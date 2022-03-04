package br.com.treino.pokedexegsys.common

import br.com.treino.pokedexegsys.api.dto.Sprites
import br.com.treino.pokedexegsys.api.model.PokemonDetailResponse

data class PokemonDetailState(
    val isLoading: Boolean = false,
    val pokemonDetail: PokemonDetailResponse = PokemonDetailResponse(
        weight = 0,
        height = 0,
        id = 0,
        types = emptyList(),
        sprites = Sprites(
            backDefault = "",
            backFemale = "",
            backShiny = "",
            backShinyFemale = "",
            frontDefault = "",
            frontFemale = "",
            frontShiny = "",
            frontShinyFemale = ""
        ),
        name = ""
    ),
    val error: String = "",
)
