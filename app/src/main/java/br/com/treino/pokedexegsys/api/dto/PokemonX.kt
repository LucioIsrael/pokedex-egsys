package br.com.treino.pokedexegsys.api.dto

data class PokemonX(
    val name: String,
    val url: String
)

fun PokemonX.toResult(): Result {
    return Result(
        name = name,
        url = url
    )
}