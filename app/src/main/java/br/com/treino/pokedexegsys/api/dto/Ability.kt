package br.com.treino.pokedexegsys.api.dto


import com.google.gson.annotations.SerializedName

data class bility(
    @SerializedName("ability")
    val ability: AbilityX,
    @SerializedName("is_hidden")
    val isHidden: Boolean,
    @SerializedName("slot")
    val slot: Int
)