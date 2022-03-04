package br.com.treino.pokedexegsys.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.treino.pokedexegsys.R
import br.com.treino.pokedexegsys.api.dto.Result
import br.com.treino.pokedexegsys.domain.PokemonListItem
import com.bumptech.glide.Glide


class PokemonAdapter(
    private var pokes: List<Result>,
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    private lateinit var pListener: onItemClickListener


    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        pListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)
        return ViewHolder(view, pListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val number =
            if(pokes[position].url.endsWith("/")) {
            pokes[position].url.dropLast(1).takeLastWhile { it.isDigit() }
        } else {
            pokes[position].url.takeLastWhile { it.isDigit() }
        }

        val item = PokemonListItem(
            number = number.toInt(),
            name = pokes[position].name
        )
        holder.bindView(item)
    }

    override fun getItemCount(): Int {
        return pokes.size
    }


    class ViewHolder(itemView: View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

        @SuppressLint("SetTextI18n")
        fun bindView(item: PokemonListItem) {
            with(itemView) {
                val ivPokemon = findViewById<ImageView>(R.id.ivPokemon)
                val tvName = findViewById<TextView>(R.id.tvName)
                val tvNumber = findViewById<TextView>(R.id.tvNumber)

                item.let {

                    Glide.with(itemView.context)
                        .load(it.imageUrl)
                        .into(ivPokemon)
                    tvNumber.text = "N° ${it.formattedNumber}"
                    tvName.text = item.formattedName

                }
            }

        }

    }
}

