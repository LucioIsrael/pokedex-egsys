package br.com.treino.pokedexegsys.api.dto


import br.com.treino.pokedexegsys.api.model.PokemonsListResponse
import com.google.gson.annotations.SerializedName

data class PokemonsListResponseDto(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val results: List<Result>
)

fun PokemonsListResponseDto.toPokemonsListResponse(): PokemonsListResponse {
    return PokemonsListResponse(
        count = count,
        results = results
    )
}