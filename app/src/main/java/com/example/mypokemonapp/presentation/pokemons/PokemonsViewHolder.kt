package com.example.mypokemonapp.presentation.pokemons

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mypokemonapp.R
import com.example.mypokemonapp.databinding.PokemonsItemBinding
import com.example.mypokemonapp.domain.model.Pokemon

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

        if (pokemon == null) {
            binding.textName.text = ""
            binding.imagePokemon.setImageDrawable(null)
            return
        }

        binding.textName.text =
            pokemon.name.replaceFirstChar { it.uppercase() }

        Glide.with(itemView.context)
            .clear(binding.imagePokemon)

        val imageUrl = pokemon.detail?.imageUrl

        if (!imageUrl.isNullOrEmpty()) {
            Glide.with(itemView.context)
                .load(imageUrl)
                .placeholder(R.drawable.pokemon_shadow)
                .error(R.drawable.ic_launcher_foreground)
                .into(binding.imagePokemon)
        } else {
            binding.imagePokemon.setImageResource(R.drawable.pokemon_shadow)
        }
    }
}