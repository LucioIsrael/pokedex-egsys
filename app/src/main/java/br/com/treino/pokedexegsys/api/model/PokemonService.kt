package br.com.treino.pokedexegsys.api.model

import br.com.treino.pokedexegsys.api.dto.PokemonDetailResponseDto
import br.com.treino.pokedexegsys.api.dto.PokemonTypeResponseDto
import br.com.treino.pokedexegsys.api.dto.PokemonsListResponseDto
import br.com.treino.pokedexegsys.util.Constants.GET_POKEMONS_END_POINT
import retrofit2.http.GET
import retrofit2.http.Path


interface PokemonService {

    @GET(GET_POKEMONS_END_POINT)
    suspend fun listPokemons(): PokemonsListResponseDto

    @GET("pokemon/{name}")
    suspend fun getPokemon(@Path("name") name:String): PokemonDetailResponseDto

    @GET("type/{typeId}")
    suspend fun getPokemonType(@Path("typeId") typeId: String): PokemonTypeResponseDto

}