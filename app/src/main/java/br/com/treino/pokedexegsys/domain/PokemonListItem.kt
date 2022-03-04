package br.com.treino.pokedexegsys.domain

import java.util.*

data class PokemonListItem(
    val number: Int,
    var name: String,
) {
    val formattedName =
        name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }

    val formattedNumber = number.toString().padStart(3, '0')
    val imageUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/$formattedNumber.png"

}

