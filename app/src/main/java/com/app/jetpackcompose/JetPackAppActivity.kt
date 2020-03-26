package com.app.jetpackcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.ContextAmbient
import androidx.ui.core.setContent
import androidx.ui.layout.Column
import androidx.ui.tooling.preview.Preview
import com.app.uiComponents.AppBarTitleIcon

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
    val context = ContextAmbient.current
    Column {
        AppBarTitleIcon(context.resources.getString(R.string.title_jetpack_app),
            R.drawable.ic_menu_black_24dp) {
            openDrawer()
        }
    }
}

@Preview
@Composable
fun JetPackAppScreenPreview() = JetPackAppScreen{}