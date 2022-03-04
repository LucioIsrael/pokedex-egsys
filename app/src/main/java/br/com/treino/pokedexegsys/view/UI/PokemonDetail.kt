package br.com.treino.pokedexegsys.view.UI

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import br.com.treino.pokedexegsys.R
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
import br.com.treino.pokedexegsys.util.Constants.NORMAL
import br.com.treino.pokedexegsys.util.Constants.NUMBER
import br.com.treino.pokedexegsys.util.Constants.POISON
import br.com.treino.pokedexegsys.util.Constants.PSYCHIC
import br.com.treino.pokedexegsys.util.Constants.ROCK
import br.com.treino.pokedexegsys.util.Constants.STEEL
import br.com.treino.pokedexegsys.util.Constants.WATER
import br.com.treino.pokedexegsys.databinding.PokemonDatailBinding
import br.com.treino.pokedexegsys.util.Constants.NONE
import br.com.treino.pokedexegsys.viewmodel.PokemonDetailViewModel
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class PokemonDetail : AppCompatActivity() {
    private val _viewModel: PokemonDetailViewModel by viewModels()

    private lateinit var binding: PokemonDatailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PokemonDatailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadPokemons()
        supportActionBar?.hide()
    }

    @SuppressLint("SetTextI18n")
    private fun loadPokemons() {
        val number = intent.getStringExtra(NUMBER) ?: NONE
        _viewModel.getPokemonDetail(pokemonName = number)
        observer()
    }

    @SuppressLint("SetTextI18n", "DefaultLocale")
    private fun observer() {
        _viewModel.pokemonDetail.observe(this) { pokemonDetail ->
            if (pokemonDetail.isLoading) {
                binding.progressBar.visibility = View.VISIBLE

            } else if (pokemonDetail.error.isNotEmpty()) {
                binding.progressBar.visibility = View.GONE
            } else {

                binding.progressBar.visibility = View.GONE
                val pokeWeight = (pokemonDetail.pokemonDetail.weight / 10f)
                val pokeHeight = (pokemonDetail.pokemonDetail.height / 10f)

                binding.tvPokeName.text = pokemonDetail.pokemonDetail.name.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
                }
                binding.pokeHeight.text = "$pokeHeight m"
                binding.pokeWeight.text = "$pokeWeight kg"
                binding.pokeNumber.text = "N° ${pokemonDetail.pokemonDetail.formattedNumber}"

                Glide.with(this)
                    .load(pokemonDetail.pokemonDetail.spriteOriginal)
                    .into(binding.ivPokeImage)

                setTypeColor(
                    typeName = pokemonDetail.pokemonDetail.types[0].type.name,
                    tvType = binding.tvType
                )

                println("TYPE ----> ${pokemonDetail.pokemonDetail.types[0].type.name}")

                if (pokemonDetail.pokemonDetail.types.size > 1) {
                    setTypeColor(
                        typeName = pokemonDetail.pokemonDetail.types[1].type.name,
                        tvType = binding.tvType2
                    )
                }

            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setTypeColor(typeName: String, tvType: TextView) {
        when (typeName) {
            NORMAL -> {
                tvType.setBackgroundResource(R.drawable.normal_type_shape)
                tvType.setTextColor(-0x1000000)
                tvType.text =
                    typeName.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            }
            FIRE -> {
                tvType.setBackgroundResource(R.drawable.fire_type_shape)
                tvType.setTextColor(-0x1)
                tvType.text =
                    typeName.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            }
            GRASS -> {
                tvType.setBackgroundResource(R.drawable.grass_type_shape)
                tvType.setTextColor(-0x1000000)
                tvType.text =
                    typeName.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            }
            WATER -> {
                tvType.setBackgroundResource(R.drawable.water_type_shape)
                tvType.setTextColor(-0x1)
                tvType.text =
                    typeName.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            }
            FLYING -> {
                tvType.setBackgroundResource(R.drawable.flying_type_shape)
                tvType.setTextColor(-0x1000000)
                tvType.text =
                    typeName.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            }
            FIGHTING -> {
                tvType.setBackgroundResource(R.drawable.fighting_type_shape)
                tvType.setTextColor(-0x1)
                tvType.text =
                    typeName.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            }
            POISON -> {
                tvType.setBackgroundResource(R.drawable.poison_type_shape)
                tvType.setTextColor(-0x1)
                tvType.text =
                    typeName.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            }
            ELECTRIC -> {
                tvType.setBackgroundResource(R.drawable.electric_type_shape)
                tvType.setTextColor(-0x1000000)
                tvType.text =
                    typeName.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            }
            GROUND -> {
                tvType.setBackgroundResource(R.drawable.ground_type_shape)
                tvType.setTextColor(-0x1000000)
                tvType.text =
                    typeName.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            }
            ROCK -> {
                tvType.setBackgroundResource(R.drawable.rock_type_shape)
                tvType.setTextColor(-0x1)
                tvType.text =
                    typeName.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            }
            PSYCHIC -> {
                tvType.setBackgroundResource(R.drawable.psychic_type_shape)
                tvType.setTextColor(-0x1)
                tvType.text =
                    typeName.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            }
            ICE -> {
                tvType.setBackgroundResource(R.drawable.ice_type_shape)
                tvType.setTextColor(-0x1000000)
                tvType.text =
                    typeName.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            }
            BUG -> {
                tvType.setBackgroundResource(R.drawable.bug_type_shape)
                tvType.setTextColor(-0x1)
                tvType.text =
                    typeName.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            }
            GHOST -> {
                tvType.setBackgroundResource(R.drawable.ghost_type_shape)
                tvType.setTextColor(-0x1)
                tvType.text =
                    typeName.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            }
            STEEL -> {
                tvType.setBackgroundResource(R.drawable.steel_type_shape)
                tvType.setTextColor(-0x1000000)
                tvType.text =
                    typeName.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            }
            DRAGON -> {
                tvType.setBackgroundResource(R.drawable.dragon_type_shape)
                tvType.setTextColor(-0x1000000)
                tvType.text =
                    typeName.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            }
            DARK -> {
                tvType.setBackgroundResource(R.drawable.dark_type_shape)
                tvType.setTextColor(-0x1)
                tvType.text =
                    typeName.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            }
            FAIRY -> {
                tvType.setBackgroundResource(R.drawable.fairy_type_shape)
                tvType.setTextColor(-0x1000000)
                tvType.text =
                    typeName.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            }
            else -> {
                tvType.setBackgroundResource(R.color.normal_type)
                tvType.text = "Tipo invalido"
            }
        }
    }


}