package com.example.mypokemonapp.presentation.pokemons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mypokemonapp.data.entity.pokemons.Pokemon
import com.example.mypokemonapp.domain.GetPokemonsUseCase
import com.example.mypokemonapp.util.state.Result
import kotlinx.coroutines.launch

class PokemonsViewModel(
    private val useCase: GetPokemonsUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<PokemonUiState>()
    val uiState: LiveData<PokemonUiState> get() = _uiState

    fun loadPokemons() {
        _uiState.value = PokemonUiState.Loading
        viewModelScope.launch {
            when (val result = useCase()) {
                is Result.Success -> {
                    _uiState.value =
                        if (result.data.isEmpty()) {
                            PokemonUiState.Empty
                        } else {
                            PokemonUiState.Success(result.data)
                        }
                }
                is Result.Error -> {
                    _uiState.value =
                        PokemonUiState.Error(result.error)
                }
            }
        }
    }
}