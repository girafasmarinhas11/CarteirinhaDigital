package com.example.carteirinhadigital.feature.carteirinha.data.repository

import com.example.carteirinhadigital.feature.carteirinha.domain.model.Carteirinha
import kotlinx.coroutines.delay

class FakeCarteirinhaRepository : CarteirinhaRepository {

    override suspend fun buscarCarteirinha(): Result<Carteirinha> {
        delay(1000)

        return Result.success(
            Carteirinha(
                nome = "Sebastian Angel Gaona Silva",
                curso = "Técnico em Desenvolvimento de Sistemas",
                turma = "4DEVMA-T23",
                matricula = "12127656",
                unidade = "SENAI Anchieta",
                status = "Ativo",
                qrCodeContent = "12127656"
            )
        )
    }
}