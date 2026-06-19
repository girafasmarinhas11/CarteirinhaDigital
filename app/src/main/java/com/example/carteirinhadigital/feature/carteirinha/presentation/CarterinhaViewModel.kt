package com.example.carteirinhadigital.feature.carteirinha.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carteirinhadigital.feature.carteirinha.data.repository.CarteirinhaRepository
import com.example.carteirinhadigital.feature.carteirinha.data.repository.FakeCarteirinhaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CarteirinhaViewModel(
    private val repository: CarteirinhaRepository = FakeCarteirinhaRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow(CarteirinhaUiState())
    val uiState: StateFlow<CarteirinhaUiState> = _uiState.asStateFlow()

    init {
        carregarCarteirinha()
    }

    fun onEvent(event: CarteirinhaEvent) {
        when (event) {
            CarteirinhaEvent.OnCarregarDados,
            CarteirinhaEvent.OnTentarNovamenteClick -> carregarCarteirinha()
            CarteirinhaEvent.OnVoltarClick -> Unit
        }
    }

    private fun carregarCarteirinha() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(isLoading = true, errorMessage = null)
            }

            val result = repository.buscarCarteirinha()

            result
                .onSuccess { dados ->
                    _uiState.update {
                        it.copy(isLoading = false, carteirinha = dados, errorMessage = null)
                    }
                }
                .onFailure { throwable ->
                    _uiState.update {
                        it.copy(isLoading = false, errorMessage = throwable.message ?: "Erro ao carregar carteirinha.")
                    }
                }
        }
    }
}