package com.example.mypokemonapp.presentation.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mypokemonapp.util.state.Result
import com.example.mypokemonapp.data.entity.details.PokemonDetail
import com.example.mypokemonapp.domain.BusinessUseCase
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val useCase: BusinessUseCase
) : ViewModel() {

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    fun isLoading(): LiveData<Boolean> = _loading

    private val _error: MutableLiveData<Throwable?> = MutableLiveData()
    fun hasError(): LiveData<Throwable?> = _error

    fun clearError() {
        _error.postValue(null)
    }

    private val _pokemonDetails: MutableLiveData<PokemonDetail?> = MutableLiveData()
    fun getPokemonDetails(): LiveData<PokemonDetail?> = _pokemonDetails

    fun loadPokemonDetails(id: String) {
        viewModelScope.launch {
            _loading.postValue(true)

            when (val result = useCase.getDetails(id)) {
                is Result.Error -> {
                    _loading.postValue(false)
                    _pokemonDetails.postValue(null)
                    _error.postValue(result.error)
                }

                is Result.Success -> {
                    if (result.data.name.isEmpty()) {
                        _loading.postValue(false)
                        _pokemonDetails.postValue(null)
                        return@launch
                    }
                    _loading.postValue(false)
                    _pokemonDetails.postValue(result.data)
                }
            }
        }
    }
}
