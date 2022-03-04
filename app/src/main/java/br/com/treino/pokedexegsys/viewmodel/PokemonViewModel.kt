package br.com.treino.pokedexegsys.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.treino.pokedexegsys.api.PokemonRepository
import br.com.treino.pokedexegsys.api.dto.Result
import br.com.treino.pokedexegsys.api.dto.toPokemonsByType
import br.com.treino.pokedexegsys.api.dto.toPokemonsListResponse
import br.com.treino.pokedexegsys.api.dto.toResult
import br.com.treino.pokedexegsys.api.model.PokemonsListResponse
import br.com.treino.pokedexegsys.util.Constants.ANY_DATA_ERROR
import br.com.treino.pokedexegsys.util.Constants.UNEXPECTED_ERROR
import br.com.treino.pokedexegsys.common.PokemonListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    private var _pokemons = MutableLiveData<PokemonListState>()
    val pokemons: LiveData<PokemonListState> = _pokemons


    val pokemonsFilter = MutableLiveData<List<Result>>()

    init {
        loadPokemons()
    }

    fun filterPokemon(filter: String) {
        pokemonsFilter.value = _pokemons.value?.pokemonsList?.results?.filter {
            it.name.contains(filter.lowercase()) }
    }

    fun loadPokemons() {
        viewModelScope.launch(Dispatchers.Main) {
            try {
                _pokemons.value = PokemonListState(isLoading = true)
                val pokemonListDto = repository.getListPokemons()
                val pokemonList = pokemonListDto.toPokemonsListResponse()
                _pokemons.value = PokemonListState(pokemonsList = pokemonList)

            } catch (e: HttpException) {
                _pokemons.value = PokemonListState(error = e.message() ?: UNEXPECTED_ERROR)
            } catch (e: IOException) {
                _pokemons.value = PokemonListState(error = ANY_DATA_ERROR)
            }

        }
    }

    fun getPokemonType(type : String) {
        viewModelScope.launch {
            try {
                _pokemons.value = PokemonListState(isLoading = true)
                val pokemonTypeDto = repository.getPokemonType(pokemonType = type)
                val pokemonType = pokemonTypeDto.toPokemonsByType()
                val pokemonTypeList: MutableList<Result> = arrayListOf()
                pokemonType.pokemon.onEach { pokemon ->
                    val temp = pokemon.pokemon.toResult()
                    pokemonTypeList.add(temp)
                }
                val pokemonTypeResults = PokemonsListResponse(results = pokemonTypeList, count = 0)
                _pokemons.value = PokemonListState(pokemonsList = pokemonTypeResults)
            } catch (e: HttpException) {
                _pokemons.value =
                    PokemonListState(error = e.message() ?: UNEXPECTED_ERROR)

            } catch (e: IOException) {
                _pokemons.value = PokemonListState(error = ANY_DATA_ERROR)
            }

        }
    }
}