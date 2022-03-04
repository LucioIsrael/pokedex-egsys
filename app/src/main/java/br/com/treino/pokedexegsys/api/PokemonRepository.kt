package br.com.treino.pokedexegsys.api

import br.com.treino.pokedexegsys.api.dto.PokemonDetailResponseDto
import br.com.treino.pokedexegsys.api.dto.PokemonTypeResponseDto
import br.com.treino.pokedexegsys.api.dto.PokemonsListResponseDto
import br.com.treino.pokedexegsys.api.model.PokemonService
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokemonService
) {
    suspend fun getListPokemons(): PokemonsListResponseDto {
        return api.listPokemons()
    }

    suspend fun getPokemonDetail(pokemonName: String): PokemonDetailResponseDto {
        return api.getPokemon(name = pokemonName)
    }

    suspend fun getPokemonType(pokemonType: String): PokemonTypeResponseDto {
        return api.getPokemonType(typeId = pokemonType)
    }
}
