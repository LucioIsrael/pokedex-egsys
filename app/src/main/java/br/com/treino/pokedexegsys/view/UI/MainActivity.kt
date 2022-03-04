package br.com.treino.pokedexegsys.view.UI

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import br.com.treino.pokedexegsys.R
import br.com.treino.pokedexegsys.api.dto.Result
import br.com.treino.pokedexegsys.util.Constants.BUG
import br.com.treino.pokedexegsys.util.Constants.DARK
import br.com.treino.pokedexegsys.util.Constants.DRAGON
import br.com.treino.pokedexegsys.util.Constants.ELECTRIC
import br.com.treino.pokedexegsys.util.Constants.FAIRY
import br.com.treino.pokedexegsys.util.Constants.FIGHTING
import br.com.treino.pokedexegsys.util.Constants.FIRE
import br.com.treino.pokedexegsys.util.Constants.FLYING
import br.com.treino.pokedexegsys.util.Constants.GHOST
import br.com.treino.pokedexegsys.util.Constants.GRASS
import br.com.treino.pokedexegsys.util.Constants.GROUND
import br.com.treino.pokedexegsys.util.Constants.ICE
import br.com.treino.pokedexegsys.util.Constants.NONE
import br.com.treino.pokedexegsys.util.Constants.NORMAL
import br.com.treino.pokedexegsys.util.Constants.NUMBER
import br.com.treino.pokedexegsys.util.Constants.POISON
import br.com.treino.pokedexegsys.util.Constants.PSYCHIC
import br.com.treino.pokedexegsys.util.Constants.ROCK
import br.com.treino.pokedexegsys.util.Constants.STEEL
import br.com.treino.pokedexegsys.util.Constants.WATER
import br.com.treino.pokedexegsys.databinding.ActivityMainBinding
import br.com.treino.pokedexegsys.view.PokemonAdapter
import br.com.treino.pokedexegsys.viewmodel.PokemonViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val _viewModel: PokemonViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observers()

    }

    @SuppressLint("ResourceType")
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        val pokeSearch: MenuItem = menu!!.findItem(R.id.search_pokemon)
        val searchView = pokeSearch.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                _viewModel.filterPokemon(filter = newText ?: "")
                return true
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.none -> {
                _viewModel.loadPokemons()
            }
            R.id.Normal_type -> {
                val typeId = filterPokemonType(NORMAL).toString()
                _viewModel.getPokemonType(typeId)
            }
            R.id.Fire_type -> {
                val typeId = filterPokemonType(FIRE).toString()
                _viewModel.getPokemonType(typeId)
            }
            R.id.Grass_type -> {
                val typeId = filterPokemonType(GRASS).toString()
                _viewModel.getPokemonType(typeId)
            }
            R.id.Water_type -> {
                val typeId = filterPokemonType(WATER).toString()
                _viewModel.getPokemonType(typeId)
            }
            R.id.Flying_type -> {
                val typeId = filterPokemonType(FLYING).toString()
                _viewModel.getPokemonType(typeId)
            }
            R.id.Fighting_type -> {
                val typeId = filterPokemonType(FIGHTING).toString()
                _viewModel.getPokemonType(typeId)
            }
            R.id.Poison_type -> {
                val typeId = filterPokemonType(POISON).toString()
                _viewModel.getPokemonType(typeId)
            }
            R.id.Electric_type -> {
                val typeId = filterPokemonType(ELECTRIC).toString()
                _viewModel.getPokemonType(typeId)
            }
            R.id.Ground_type -> {
                val typeId = filterPokemonType(GROUND).toString()
                _viewModel.getPokemonType(typeId)
            }
            R.id.Rock_type -> {
                val typeId = filterPokemonType(ROCK).toString()
                _viewModel.getPokemonType(typeId)
            }
            R.id.Psychic -> {
                val typeId = filterPokemonType(PSYCHIC).toString()
                _viewModel.getPokemonType(typeId)
            }
            R.id.Ice_type -> {
                val typeId = filterPokemonType(ICE).toString()
                _viewModel.getPokemonType(typeId)
            }
            R.id.Bug_type -> {
                val typeId = filterPokemonType(BUG).toString()
                _viewModel.getPokemonType(typeId)
            }
            R.id.Ghost_type -> {
                val typeId = filterPokemonType(GHOST).toString()
                _viewModel.getPokemonType(typeId)
            }
            R.id.Steel_type -> {
                val typeId = filterPokemonType(STEEL).toString()
                _viewModel.getPokemonType(typeId)
            }
            R.id.Dragon_type -> {
                val typeId = filterPokemonType(DRAGON).toString()
                _viewModel.getPokemonType(typeId)
            }
            R.id.Dark_type -> {
                val typeId = filterPokemonType(DARK).toString()
                _viewModel.getPokemonType(typeId)
            }
            R.id.Fairy_type -> {
                val typeId = filterPokemonType(FAIRY).toString()
                _viewModel.getPokemonType(typeId)
            }
        }


        return super.onOptionsItemSelected(item)
    }

    private fun filterPokemonType(type: String): Int {
        var id = 0
        when (type) {
            NONE -> {
                id = 0
            }
            NORMAL -> {
                id = 1
            }
            FIGHTING -> {
                id = 2
            }
            FLYING -> {
                id = 3
            }
            POISON -> {
                id = 4
            }
            GROUND -> {
                id = 5
            }
            ROCK -> {
                id = 6
            }
            BUG -> {
                id = 7
            }
            GHOST -> {
                id = 8
            }
            STEEL -> {
                id = 9
            }
            FIRE -> {
                id = 10
            }
            WATER -> {
                id = 11
            }
            GRASS -> {
                id = 12
            }
            ELECTRIC -> {
                id = 13
            }
            PSYCHIC -> {
                id = 14
            }
            ICE -> {
                id = 15
            }
            DRAGON -> {
                id = 16
            }
            DARK -> {
                id = 17
            }
            FAIRY -> {
                id = 18
            }
            else -> {
                id = 0
            }
        }
        return id
    }


    private fun observers() {
        _viewModel.pokemonsFilter.observe(this, Observer { pokemonsList ->
            if (pokemonsList.isNotEmpty()) {
                loadRecyclerView(pokemonsList)
            }
        })
        _viewModel.pokemons.observe(this, Observer { state ->
            if (state.isLoading) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
            if (state.pokemonsList.results.isNotEmpty()) {
                loadRecyclerView(state.pokemonsList.results)
            }
            if (state.error.isNotEmpty()) {
                println("ERROR")
            }
        })
    }

    private fun loadRecyclerView(pokemonList: List<Result>) {
        val adapterP = PokemonAdapter(pokemonList)
        binding.rvPokemons.layoutManager = GridLayoutManager(this, 2)
        binding.rvPokemons.adapter = adapterP


        adapterP.setOnItemClickListener(object : PokemonAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {

                val intent = Intent(applicationContext, PokemonDetail::class.java)
                intent.putExtra(NUMBER, pokemonList[position].name)

                startActivity(intent)

            }
        })

        binding.buttonRandom.setOnClickListener(View.OnClickListener {
            val number = pokemonList.size
            val numberRandom = (Random().nextInt(number)) + 1
            val intent = Intent(applicationContext, PokemonDetail::class.java)
            intent.putExtra(NUMBER, numberRandom.toString())
            startActivity(intent)

        })
    }

}



