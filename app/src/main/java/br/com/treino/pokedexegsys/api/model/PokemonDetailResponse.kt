package br.com.treino.pokedexegsys.api.model

import br.com.treino.pokedexegsys.api.dto.Sprites
import br.com.treino.pokedexegsys.api.dto.Type

data class PokemonDetailResponse(
    val weight: Int,
    val height: Int,
    val id: Int,
    val types: List<Type>,
    val sprites: Sprites,
    val name: String,
) {

    val formattedNumber = id.toString().padStart(3, '0')
    val spriteOriginal = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/$formattedNumber.png"

}
