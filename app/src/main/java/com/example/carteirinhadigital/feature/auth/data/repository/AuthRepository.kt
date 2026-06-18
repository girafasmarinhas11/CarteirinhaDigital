package com.example.carteirinhadigital.feature.auth.data.repository

import com.example.carteirinhadigital.feature.auth.domain.model.UsuarioLogado

interface AuthRepository {
    suspend fun login(login: String, senha: String): Result<UsuarioLogado>
}