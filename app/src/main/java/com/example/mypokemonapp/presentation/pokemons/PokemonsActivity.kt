package com.example.mypokemonapp.presentation.pokemons

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mypokemonapp.util.extensions.gone
import com.example.mypokemonapp.util.extensions.visible
import com.example.mypokemonapp.data.entity.pokemons.Pokemon
import com.example.mypokemonapp.databinding.PokemonsActivityBinding
import com.example.mypokemonapp.presentation.details.DetailsActivity
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonsActivity : AppCompatActivity() {

    private lateinit var adapter: PokemonsAdapter

    private val binding by lazy {
        PokemonsActivityBinding.inflate(layoutInflater)
    }

    private val viewModel: PokemonsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        this.adapter = PokemonsAdapter(pokemons = arrayOf(), onclick = ::showDetailsPokemon)
        binding.recyclerView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager

        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )

        binding.btnTryAgain.setOnClickListener {
            binding.btnTryAgain.gone()
            viewModel.loadPokemons()
        }

        viewModel.isLoading().observe(this) { isLoading ->
            if (isLoading) {
                binding.recyclerView.gone()
                binding.emptyList.gone()
                binding.progress.visible()
            } else {
                binding.progress.gone()
            }
        }

        viewModel.hasError().observe(this) {
            if (it == null) return@observe
            binding.btnTryAgain.visible()
            val snackbar = Snackbar.make(
                binding.root,
                it.message!!,
                Snackbar.LENGTH_SHORT
            )
            snackbar.setAction("Ok") { viewModel.clearError() }
            snackbar.show()
        }
        viewModel.getPokemons().observe(this) { pokemons ->
            adapter.setPokemon(pokemons)
            binding.recyclerView.visible()
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadPokemons()
    }

    fun showDetailsPokemon(pokemon: Pokemon?) {
        val intent = Intent(baseContext, DetailsActivity::class.java)
        intent.putExtra("pokemon", pokemon)
        startActivity(intent)
    }
}