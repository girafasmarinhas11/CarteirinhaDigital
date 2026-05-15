package com.example.carteirinhadigital.feature.unidadecurricular.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.carteirinhadigital.feature.unidadecurricular.domain.model.UnidadeCurricular

@Composable //toda anotação tem que ter ele (TELA)
fun UnidadeCurricularCard(
    modifier: Modifier = Modifier,
    unidadeCurricular: UnidadeCurricular){ //função componente
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(size = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(

                text = unidadeCurricular.nome,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = unidadeCurricular.professor,
                style = MaterialTheme.typography.bodyMedium,
                )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "N1: ${unidadeCurricular.nota1}"
                )
                Text(
                    text = "N2: ${unidadeCurricular.nota2}"
                )
                Text(
                    text = "Média: ${unidadeCurricular.media}"
                )
            }
            Text(
                text = "Faltas: ${unidadeCurricular.faltas}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }

    }
}

@Preview(
    showBackground = true
)
@Composable
fun UnidadeCurricularCardPreview(){
    UnidadeCurricularCard(
        unidadeCurricular = UnidadeCurricular(
            id = "1",
            nome = "Matemática",
            professor = "Dr. Silva",
            nota1 = 8.5,
            nota2 = 7.0,
            media = 7.75,
            faltas = 2
        )
    )
}