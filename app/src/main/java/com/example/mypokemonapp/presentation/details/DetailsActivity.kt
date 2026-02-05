package com.example.mypokemonapp.presentation.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.mypokemonapp.R
import com.example.mypokemonapp.databinding.DetailsActivityBinding
import com.example.mypokemonapp.util.extensions.formatPokemonMeasurement
import com.example.mypokemonapp.util.extensions.gone
import com.example.mypokemonapp.util.extensions.visible
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: DetailsActivityBinding

    private val viewModel: DetailsViewModel by viewModel()

    private lateinit var pokemonName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DetailsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pokemonName = getPokemonNameOrFinish()

        setupListeners()
        observeUiState()

        viewModel.loadPokemonDetails(pokemonName)
    }

    private fun getPokemonNameOrFinish(): String {
        return intent.getStringExtra(EXTRA_POKEMON_NAME)
            ?: run {
                finish()
                return ""
            }
    }

    private fun setupListeners() {
        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.btnTryAgain.setOnClickListener {
            viewModel.loadPokemonDetails(pokemonName)
        }
    }

    private fun observeUiState() {
        viewModel.uiState.observe(this) { state ->
            when (state) {
                is DetailsUiState.Loading -> renderLoading()
                is DetailsUiState.Success -> renderSuccess(state)
                is DetailsUiState.Error -> renderError(state)
                is DetailsUiState.Empty -> renderEmpty()
            }
        }
    }

    private fun renderLoading() = with(binding) {
        progress.visible()
        scrollContent.gone()
        btnTryAgain.gone()
    }

    private fun renderError(state: DetailsUiState.Error) = with(binding) {
        progress.gone()
        scrollContent.gone()
        btnTryAgain.visible()

        Snackbar.make(
            root,
            state.cause.message ?: getString(R.string.generic_error),
            Snackbar.LENGTH_SHORT
        ).show()
    }

    private fun renderSuccess(state: DetailsUiState.Success) = with(binding) {
        progress.gone()
        btnTryAgain.gone()
        scrollContent.visible()

        val pokemon = state.pokemon

        numberResponse.text =
            getString(R.string.id_pokemon, pokemon.id.toString())

        pokemonName.text = pokemon.name

        heightResponse.text = getString(
            R.string.height_value,
            formatPokemonMeasurement(
                isHeight = true,
                value = pokemon.height
            )
        )

        weightResponse.text = getString(
            R.string.weight_value,
            formatPokemonMeasurement(
                isHeight = false,
                value = pokemon.weight
            )
        )

        if (pokemon.imageUrl.isNotEmpty()) {
            Glide.with(this@DetailsActivity)
                .load(pokemon.imageUrl)
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_launcher_foreground)
                .into(pokemonImage)
        }
    }

    private fun renderEmpty() = with(binding) {
        progress.gone()
        scrollContent.gone()
        btnTryAgain.gone()
    }

    companion object {
        const val EXTRA_POKEMON_NAME = "extra_pokemon_name"
    }
}