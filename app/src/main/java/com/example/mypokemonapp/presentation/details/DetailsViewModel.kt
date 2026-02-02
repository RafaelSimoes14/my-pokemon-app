package com.example.mypokemonapp.presentation.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mypokemonapp.domain.usecase.GetPokemonDetailUseCase
import com.example.mypokemonapp.util.state.Result
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val useCase: GetPokemonDetailUseCase
) : ViewModel() {
    private val _uiState = MutableLiveData<DetailsUiState>()
    val uiState: LiveData<DetailsUiState> get() = _uiState

    fun loadPokemonDetails(id: String) {
        _uiState.value = DetailsUiState.Loading

        viewModelScope.launch {
            when (val result = useCase.invoke(id)) {
                is Result.Success -> {
                    _uiState.value = DetailsUiState.Success(result.data)
                }
                is Result.Error -> {
                    _uiState.value = DetailsUiState.Error(result.error)
                }
            }
        }
    }
}