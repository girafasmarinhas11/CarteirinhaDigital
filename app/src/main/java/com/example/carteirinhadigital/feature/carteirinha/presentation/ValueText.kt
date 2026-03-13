package com.example.carteirinhadigital.feature.carteirinha.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun ValueText(
    value: String,
    fontSize: TextUnit = MaterialTheme.typography.titleLarge.fontSize,
    fontWeight: FontWeight = MaterialTheme.typography.titleLarge.fontWeight ?: FontWeight.Normal,
    modifier: Modifier = Modifier
){
    Text(
        text = value,
        fontSize = fontSize,
        fontWeight = fontWeight,
        fontFamily = MaterialTheme.typography.titleLarge.fontFamily,
        lineHeight = MaterialTheme.typography.titleLarge.lineHeight,
        modifier = modifier
            .padding(start = 8.dp),
        softWrap = true,
        color = MaterialTheme.colorScheme.onSurface
    )
}