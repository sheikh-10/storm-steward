package com.application.stormsteward.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GameScreen(modifier: Modifier = Modifier) {
    Column {
        Text(text = "Hello World")
    }
}