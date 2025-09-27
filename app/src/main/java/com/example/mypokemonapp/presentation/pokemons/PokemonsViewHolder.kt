package com.example.mypokemonapp.presentation.pokemons

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mypokemonapp.R
import com.example.mypokemonapp.data.entity.pokemons.Pokemon
import com.example.mypokemonapp.databinding.PokemonsItemBinding

class PokemonsViewHolder(
    private val binding: PokemonsItemBinding,
    onClick: (pokemon: Pokemon?) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private var pokemons: Pokemon? = null

    init {
        binding.root.setOnClickListener { onClick(pokemons) }
    }

    fun setPokemon(pokemon: Pokemon?) {
        this.pokemons = pokemon
        if (pokemon != null) {
            binding.textName.text = pokemon.name.replaceFirstChar { it.uppercase() }

            Glide.with(itemView.context).clear(binding.imagePokemon)

            val image = pokemon.detail?.sprites?.other?.officialArtwork?.frontDefault
            if (!image.isNullOrEmpty()) {
                Glide.with(itemView.context)
                    .load(image)
                    .placeholder(R.drawable.pokemon_shadow)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(binding.imagePokemon)
            }
        }
    }
}