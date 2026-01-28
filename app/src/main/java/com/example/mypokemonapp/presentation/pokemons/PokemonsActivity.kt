package com.example.mypokemonapp.presentation.pokemons

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mypokemonapp.data.entity.pokemons.Pokemon
import com.example.mypokemonapp.databinding.PokemonsActivityBinding
import com.example.mypokemonapp.presentation.details.DetailsActivity
import com.example.mypokemonapp.util.extensions.gone
import com.example.mypokemonapp.util.extensions.visible
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonsActivity : AppCompatActivity() {

    private lateinit var adapter: PokemonsAdapter

    private lateinit var binding: PokemonsActivityBinding

    private val viewModel: PokemonsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PokemonsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        setupListeners()
        observeUiState()
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadPokemons()
    }

    private fun setupRecyclerView() {
        adapter = PokemonsAdapter(
            pokemons = arrayOf(),
            onclick = ::showDetailsPokemon
        )

        binding.recyclerView.apply {
            adapter = this@PokemonsActivity.adapter
            layoutManager = LinearLayoutManager(this@PokemonsActivity)
            addItemDecoration(
                DividerItemDecoration(
                    this@PokemonsActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    private fun setupListeners() {
        binding.btnTryAgain.setOnClickListener {
            viewModel.loadPokemons()
        }
    }

    private fun observeUiState() {
        viewModel.uiState.observe(this) { state ->
            when (state) {
                is PokemonUiState.Loading -> renderLoading()
                is PokemonUiState.Success -> renderSuccess(state)
                is PokemonUiState.Empty -> renderEmpty()
                is PokemonUiState.Error -> renderError(state)
            }
        }
    }

    private fun renderLoading() {
        binding.progress.visible()
        binding.recyclerView.gone()
        binding.emptyList.gone()
        binding.btnTryAgain.gone()
    }

    private fun renderSuccess(state: PokemonUiState.Success) {
        binding.progress.gone()
        binding.emptyList.gone()
        binding.btnTryAgain.gone()

        adapter.setPokemon(state.pokemons)
        binding.recyclerView.visible()
    }

    private fun renderEmpty() {
        binding.progress.gone()
        binding.recyclerView.gone()
        binding.btnTryAgain.gone()
        binding.emptyList.visible()
    }

    private fun renderError(state: PokemonUiState.Error) {
        binding.progress.gone()
        binding.recyclerView.gone()
        binding.btnTryAgain.visible()

        Snackbar.make(
            binding.root,
            state.cause.message ?: "Erro ao carregar pokémons",
            Snackbar.LENGTH_SHORT
        ).show()
    }

    private fun showDetailsPokemon(pokemon: Pokemon?) {
        val intent = Intent(this, DetailsActivity::class.java).apply {
            putExtra(DetailsActivity.EXTRA_POKEMON_NAME, pokemon?.name)
        }
        startActivity(intent)
    }
}