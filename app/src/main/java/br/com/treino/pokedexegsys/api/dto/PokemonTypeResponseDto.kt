package br.com.treino.pokedexegsys.api.dto

import br.com.treino.pokedexegsys.api.model.PokemonsByType
import com.google.gson.annotations.SerializedName

data class PokemonTypeResponseDto(
    @SerializedName("damage_relations")
    val damageRelations: DamageRelations,
    @SerializedName("game_indices")
    val gameIndices: List<GameIndiceX>,
    @SerializedName("generation")
    val generation: GenerationX,
    @SerializedName("id")
    val id: Int,
    @SerializedName("move_damage_class")
    val moveDamageClass: MoveDamageClass,
    @SerializedName("moves")
    val moves: List<MoveXX>,
    @SerializedName("name")
    val name: String,
    @SerializedName("names")
    val names: List<Name>,
    @SerializedName("past_damage_relations")
    val pastDamageRelations: List<Any>,
    @SerializedName("pokemon")
    val pokemon: List<Pokemon>
)

fun PokemonTypeResponseDto.toPokemonsByType(): PokemonsByType{
    return PokemonsByType(
        pokemon = pokemon
    )
}