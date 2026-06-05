package com.example.mypokemonapp.presentation.pokemons

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.mypokemonapp.databinding.PokemonsItemBinding
import com.example.mypokemonapp.domain.model.Pokemon

class PokemonsAdapter(
    private val onclick: (Pokemon) -> Unit
) : ListAdapter<Pokemon, PokemonsViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonsViewHolder {
        val binding =
            PokemonsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonsViewHolder(binding, onclick)
    }

    override fun onBindViewHolder(holder: PokemonsViewHolder, position: Int) {
        holder.setPokemon(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Pokemon>() {
            override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon) = oldItem == newItem
        }
    }
}