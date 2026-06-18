package com.example.carteirinhadigital.feature.auth.data.repository

import com.example.carteirinhadigital.feature.auth.domain.model.UsuarioLogado
import kotlinx.coroutines.delay

class FakeAuthRepository : AuthRepository {

    override suspend fun login(login: String, senha: String): Result<UsuarioLogado> {
        delay(1000)

        return if (login.trim() == "david" && senha == "24247656") {
            Result.success(
                UsuarioLogado(
                    id = "1",
                    nome = "David Souza Santos",
                    token = "token-david"
                )
            )
        } else {
            Result.failure(
                IllegalArgumentException("Login ou senha inválidos.")
            )
        }
    }
}