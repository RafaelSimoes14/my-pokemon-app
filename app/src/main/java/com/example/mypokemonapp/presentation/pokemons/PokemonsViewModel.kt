package com.example.mypokemonapp.presentation.pokemons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mypokemonapp.util.state.Result
import com.example.mypokemonapp.data.entity.pokemons.Pokemon
import com.example.mypokemonapp.domain.BusinessUseCase
import kotlinx.coroutines.launch

class PokemonsViewModel(
    private val useCase: BusinessUseCase
) : ViewModel() {

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    fun isLoading(): LiveData<Boolean> = _loading

    private val _error: MutableLiveData<Throwable?> = MutableLiveData()
    fun hasError(): LiveData<Throwable?> = _error

    fun clearError() {
        _error.postValue(null)
    }

    private val _pokemons: MutableLiveData<List<Pokemon>> = MutableLiveData(listOf())
    fun getPokemons(): LiveData<List<Pokemon>> = _pokemons

    fun loadPokemons() {
        viewModelScope.launch {
            _loading.postValue(true)
            when (val result = useCase.getPokemon()) {
                is Result.Error -> {
                    _loading.postValue(false)
                    _pokemons.postValue(listOf())
                    _error.postValue(result.error)
                }

                is Result.Success -> {
                    if (result.data.isEmpty()) {
                        _loading.postValue(false)
                        _pokemons.postValue(listOf())
                        return@launch
                    }
                    _loading.postValue(false)
                    _pokemons.postValue(result.data)
                }
            }
        }
    }
}