package com.example.carteirinhadigital.feature.unidadecurricular.data.repository

import com.example.carteirinhadigital.feature.unidadecurricular.domain.model.UnidadeCurricular
import kotlinx.coroutines.delay

class FakeUnidadeCurricularRepository : UnidadeCurricularRepository {
    override suspend fun buscarUnidadesCurriculares(): Result<List<UnidadeCurricular>> {
        delay(1800)

        return Result.success(
            listOf(
                UnidadeCurricular("1", "IoT - Internet das Coisas", "Lucas Felfoldi", 50.0, 100.0, 75.0, 23),
                UnidadeCurricular("2", "Programação Frontend 2", "Rafael Oliveira", 50.0, 100.0, 75.0, 12),
                UnidadeCurricular("3", "Programação Para Dispositivos Mobile", "Rafael Costa", 50.0, 90.0, 70.0, 20),
                UnidadeCurricular("4", "Projeto de Software 3", "Rafael Costa", 50.0, 84.0, 67.0, 9),
                UnidadeCurricular("5", "Teste de Software", "Rafael Costa", 50.0, 60.0, 55.0, 15),
            )
        )
    }
}