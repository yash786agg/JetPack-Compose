package com.app.uiComponents

import androidx.compose.Composable
import androidx.ui.core.Text

@Composable
fun TextView(text: Any?) {
    Text(text = text.toString())
}