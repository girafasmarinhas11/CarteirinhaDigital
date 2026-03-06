package com.example.carteirinhadigital

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LabelText(
    label: String,
    modifier: Modifier = Modifier
){
    Text(
        text = label,
        textAlign = TextAlign.Right,
        style = MaterialTheme.typography.bodyLarge,
        fontFamily = MaterialTheme.typography.bodyLarge.fontFamily,
        modifier = modifier,
        color = MaterialTheme.colorScheme.onSurface
    )
}

/*@Preview()
@Composable
fun LabelTextClaroPreview(){

}*/