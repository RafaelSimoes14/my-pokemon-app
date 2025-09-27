package com.example.mypokemonapp.presentation.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.mypokemonapp.R
import com.example.mypokemonapp.data.entity.pokemons.Pokemon
import com.example.mypokemonapp.databinding.DetailsActivityBinding
import com.example.mypokemonapp.util.extensions.formatPokemonMeasurement
import com.example.mypokemonapp.util.extensions.gone
import com.example.mypokemonapp.util.extensions.visible
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsActivity : AppCompatActivity() {
    private val binding by lazy {
        DetailsActivityBinding.inflate(layoutInflater)
    }

    private val viewModel: DetailsViewModel by viewModel()

    private lateinit var pokemonName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val pokemon: Pokemon? = intent.extras?.getParcelable("pokemon")

        pokemonName = pokemon?.name.toString()

        viewModel.loadPokemonDetails(pokemonName)

        binding.btnBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }

        binding.btnTryAgain.setOnClickListener {
            binding.btnTryAgain.gone()
            viewModel.loadPokemonDetails(pokemonName)
        }

        viewModel.isLoading().observe(this) { isLoading ->
            if (isLoading) {
                binding.progress.visible()
                binding.scrollContent.gone()


            } else {
                binding.progress.gone()
                binding.scrollContent.visible()
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
        viewModel.getPokemonDetails().observe(this) { detail ->
            if (detail != null) {
                binding.numberResponse.text = getString(R.string.id_pokemon, detail.id.toString())
                binding.pokemonName.text = detail.name.replaceFirstChar { it.uppercase() }
                binding.heightResponse.text = getString(
                    R.string.height_value, formatPokemonMeasurement(
                        isHeight = true,
                        value = detail.height
                    )
                )
                binding.weightResponse.text = getString(
                    R.string.weight_value, formatPokemonMeasurement(
                        value = detail.weight,
                        isHeight = false
                    )
                )
            }

            val image = detail?.sprites?.other?.officialArtwork?.frontDefault
            if (image.isNullOrEmpty()) return@observe
            if (image != null) {
                Glide.with(this)
                    .load(image)
                    .placeholder(R.drawable.ic_placeholder)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(binding.pokemonImage)
            }
        }
    }
}