package com.example.carteirinhadigital.feature.unidadecurricular.domain.model

class UnidadeCurricular(
) {
    val id: String,
    val nome: String,
    val professor: String,
    val nota1: Double,
    val nota2: Double,
    val media: Double,
    val faltas: Int
}