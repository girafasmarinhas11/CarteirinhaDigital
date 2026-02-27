package com.example.carteirinhadigital

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.carteirinhadigital.ui.theme.CarteirinhaDigitalTheme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CarteirinhaDigitalTheme {
                Scaffold { innerPadding ->

                    CarteirinhaDigital(
                        modifier = Modifier.padding(paddingValues = innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun CarteirinhaDigital(modifier: Modifier = Modifier) {
    // Definindo as cores do SENAI (Vermelho/Azul/Branco)
    val senaiRed = Color(0xFFE30613)
    val senaiBlue = Color(0xFF005DAA)

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFFF5F5F5), Color(0xFFE0E0E0)))),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
                .wrapContentHeight(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp)
        ) {
            Column(
                modifier = Modifier.padding(bottom = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Header com a Logo
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(senaiRed)
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo_senai),
                        contentDescription = "Logo SENAI",
                        modifier = Modifier.height(40.dp)
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Foto de Perfil com Borda
                Surface(
                    modifier = Modifier
                        .size(140.dp)
                        .border(4.dp, senaiBlue, CircleShape)
                        .padding(4.dp)
                        .clip(CircleShape),
                    color = Color.LightGray
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.avatar),
                        contentDescription = "Foto do Aluno",
                        contentScale = ContentScale.Crop
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Informações do Aluno Sebastian
                Text(
                    text = "Sebastian Angel Gaona Silva",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Text(
                    text = "Unidade: 109 - Anchieta",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(16.dp))

                Divider(modifier = Modifier.padding(horizontal = 32.dp), thickness = 0.5.dp)

                Spacer(modifier = Modifier.height(16.dp))

                // Curso
                Text(
                    text = "CURSO",
                    style = MaterialTheme.typography.labelSmall,
                    color = senaiBlue,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Desenvolvimento de Sistemas",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.DarkGray
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Área do QR Code
                Surface(
                    modifier = Modifier
                        .size(120.dp)
                        .padding(8.dp),
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFFF8F8F8),
                    border = androidx.compose.foundation.BorderStroke(1.dp, Color.LightGray)
                ) {
                    QrCode(conteudo = "90000000001417104860")
                }

                Text(
                    text = "Válido em todo território nacional",
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.LightGray,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}
