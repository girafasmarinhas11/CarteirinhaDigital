package com.example.carteirinhadigital.feature.unidadecurricular.presentation.screen

import com.example.carteirinhadigital.feature.unidadecurricular.domain.model.UnidadeCurricular

data class UnidadeCurricularUiState(
    val isLoading: Boolean = false,
    val unidadesCurriculares: List<UnidadeCurricular> = emptyList(),
    val errorMessage: String? = null
)