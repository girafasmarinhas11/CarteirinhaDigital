package com.example.carteirinhadigital.feature.auth.presentation.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.carteirinhadigital.core.designsystem.component.AppTopBar
import com.example.carteirinhadigital.feature.auth.domain.model.UsuarioLogado
import com.example.carteirinhadigital.feature.auth.presentation.LoginEvent
import com.example.carteirinhadigital.feature.auth.presentation.LoginViewModel

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onLoginSuccess: (UsuarioLogado) -> Unit,
    viewModel: LoginViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(uiState.usuarioLogado) {
        uiState.usuarioLogado?.let { usuario ->
            viewModel.onEvent(LoginEvent.OnNavegacaoRealizada)
            onLoginSuccess(usuario)
        }
    }

    Scaffold(
        topBar = {
            AppTopBar(
                title = "Login",
                subtitle = "Acesse sua carteirinha digital"
            )
        }
    ) { innerPadding ->
        LoginContent(
            uiState = uiState,
            onEvent = viewModel::onEvent,
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}