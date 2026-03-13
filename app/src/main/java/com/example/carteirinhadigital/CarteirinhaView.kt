package com.example.carteirinhadigital

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rafaelcosta.myapplication.QrCode

@Composable
fun CarteirinhaView (modifier: Modifier = Modifier){
    Box(){
        Image(
            painter = painterResource(R.drawable.logo_senai),
            contentDescription = "Fundo da Carteirinha",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(R.drawable.logo_senai),
                contentDescription = "Logo do Senai",
                modifier = Modifier
                    .weight(.2f)
                    .padding(top = 0.dp, bottom = 0.dp)
                    .size(200.dp)
            )
            Image(
                painter = painterResource(R.drawable.logo_senai),
                contentDescription = "Foto de Perfil",
                modifier = Modifier
                    .weight(.2f)
                    .padding(top = 0.dp, bottom = 0.dp)
            )
            Row(
                modifier = Modifier.weight(.1f)
            ){
                Text("Nome: ", color = Color.White)
                Text("David Souza Santos", color = Color.White)
            }
            Row(
                modifier = Modifier.weight(.1f)
            ){
                Text("Curso: ", color = Color.White)
                Text("Desenvolvimento de Sistemas", color = Color.White)
            }
            QrCode(
                "90000000001417180476",
                modifier = Modifier
                    .weight(.2f)
                    .fillMaxSize(.6f)
                    .clip(RoundedCornerShape(20.dp))
            )
        }
    }
}