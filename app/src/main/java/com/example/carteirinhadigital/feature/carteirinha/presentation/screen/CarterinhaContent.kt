package com.example.carteirinhadigital.feature.carteirinha.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.carteirinhadigital.R
import com.example.carteirinhadigital.core.designsystem.theme.CarteirinhaDigitalTheme
import com.example.carteirinhadigital.feature.carteirinha.domain.model.Carteirinha
import com.example.carteirinhadigital.feature.carteirinha.presentation.CarteirinhaEvent
import com.example.carteirinhadigital.feature.carteirinha.presentation.CarteirinhaUiState
import com.example.carteirinhadigital.feature.carteirinha.presentation.component.PerfilAluno
import com.example.carteirinhadigital.feature.carteirinha.presentation.component.QrCode

@Composable
fun CarteirinhaContent(
    uiState: CarteirinhaUiState,
    onEvent: (CarteirinhaEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.formulaum),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.7f)
        )

        when {
            uiState.isLoading -> {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    CircularProgressIndicator()
                    Text("Buscando dados da carteirinha...")
                }
            }

            uiState.errorMessage != null -> {
                Column(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    Text(
                        text = uiState.errorMessage,
                        color = MaterialTheme.colorScheme.error
                    )
                    Button(onClick = { onEvent(CarteirinhaEvent.OnTentarNovamenteClick) }) {
                        Text("Tentar novamente")
                    }
                }
            }

            uiState.carteirinha != null -> {
                CarteirinhaDadosContent(
                    carteirinha = uiState.carteirinha,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Composable
private fun CarteirinhaDadosContent(
    carteirinha: Carteirinha,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .safeDrawingPadding()
            .fillMaxSize()
            .padding(vertical = 18.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.logo_senai),
            contentDescription = "Logo do SENAI São Paulo",
            modifier = Modifier.fillMaxWidth(0.34f)
        )

        PerfilAluno(
            nome = carteirinha.nome,
            curso = carteirinha.curso,
            turma = carteirinha.turma,
            matricula = carteirinha.matricula,
            unidade = carteirinha.unidade,
            status = carteirinha.status,
            modifier = Modifier.fillMaxWidth(0.86f)
        )

        QrCode(
            conteudo = carteirinha.qrCodeContent,
            modifier = Modifier.fillMaxWidth(0.24f)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CarteirinhaContentPreviewClaro() {
    CarteirinhaDigitalTheme(darkTheme = false) {
        CarteirinhaContent(
            uiState = CarteirinhaUiState(
                carteirinha = Carteirinha(
                    nome = "Rafael Costa",
                    curso = "Técnico em Desenvolvimento de Sistemas",
                    turma = "4DEVM-T1",
                    matricula = "20260001",
                    unidade = "SENAI Anchieta",
                    status = "Ativo",
                    qrCodeContent = "20260001"
                )
            ),
            onEvent = {}
        )
    }
}