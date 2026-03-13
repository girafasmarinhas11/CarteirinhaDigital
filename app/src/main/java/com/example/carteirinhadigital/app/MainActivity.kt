package com.example.carteirinhadigital.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.ui.tooling.preview.Preview
import com.example.carteirinhadigital.feature.carteirinha.presentation.component.CarteirinhaScreen
import com.example.carteirinhadigital.ui.theme.CarteirinhaDigitalTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CarteirinhaDigitalTheme() {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            colors = topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary,
                            ),
                            title = {
                                Text("Carteirinha de Estudante Digital")
                            }
                        )
                    }
                ) { innerPadding ->
                    CarteirinhaScreen(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PreviewAppClaro() {
    CarteirinhaDigitalTheme(darkTheme = false) {
        CarteirinhaScreen()
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PreviewAppEscuro() {
    CarteirinhaDigitalTheme(darkTheme = true) {
        CarteirinhaScreen()
    }
}