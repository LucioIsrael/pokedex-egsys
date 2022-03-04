package br.com.treino.pokedexegsys.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.treino.pokedexegsys.api.PokemonRepository
import br.com.treino.pokedexegsys.api.dto.*
import br.com.treino.pokedexegsys.util.Constants
import br.com.treino.pokedexegsys.common.PokemonDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository,
) : ViewModel() {

    private var _pokemonDetail = MutableLiveData<PokemonDetailState>()
    val pokemonDetail: LiveData<PokemonDetailState> = _pokemonDetail


    fun getPokemonDetail(pokemonName: String) {
        viewModelScope.launch(Dispatchers.Main) {
            try {
                _pokemonDetail.value = PokemonDetailState(isLoading = true)
                val pokemonDetailDto = repository.getPokemonDetail(pokemonName = pokemonName)
                val pokemonDetailItem = pokemonDetailDto.toPokemonDetailResponse()
                _pokemonDetail.value = PokemonDetailState(pokemonDetail = pokemonDetailItem)

            } catch (e: HttpException) {
                _pokemonDetail.value =
                    PokemonDetailState(error = e.message() ?: Constants.UNEXPECTED_ERROR)
            } catch (e: IOException) {
                _pokemonDetail.value = PokemonDetailState(error = Constants.ANY_DATA_ERROR)
            }
        }
    }
}

