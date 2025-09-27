package com.example.mypokemonapp.presentation.pokemons

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mypokemonapp.data.entity.pokemons.Pokemon
import com.example.mypokemonapp.databinding.PokemonsItemBinding

class PokemonsAdapter(
    private var pokemons: Array<Pokemon>,
    private val onclick: (pokemon: Pokemon?) -> Unit
) : RecyclerView.Adapter<PokemonsViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PokemonsViewHolder {
        val binding =
            PokemonsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonsViewHolder(binding, onclick)
    }

    override fun onBindViewHolder(
        holder: PokemonsViewHolder,
        position: Int
    ) {
        val pokemon: Pokemon = pokemons[position]
        holder.setPokemon(pokemon)
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }

    fun setPokemon(values: List<Pokemon>?){
        this.pokemons = values?.toTypedArray() ?: arrayOf()
        notifyDataSetChanged()
    }
}