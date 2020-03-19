package com.app.jetpackcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.setContent
import androidx.ui.tooling.preview.Preview

class JetPackAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackAppScreen{}
        }
    }
}

@Composable
fun JetPackAppScreen(openDrawer: () -> Unit)  {

}

@Preview
@Composable
fun JetPackAppScreenPreview() = JetPackAppScreen{}