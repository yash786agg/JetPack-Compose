package com.app.jetpackcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.ambient
import androidx.compose.unaryPlus
import androidx.core.content.ContextCompat
import androidx.ui.core.*
import androidx.ui.graphics.imageFromResource
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.tooling.preview.Preview
import com.app.uiComponents.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppBar()
        }
    }
}

@Composable
fun AppBar() = MaterialTheme {
    val context = +ambient(ContextAmbient)
    FlexColumn {
        inflexible {
            AppBarTitle(context.resources.getString(R.string.app_name))
            HeightSpacer(height = 15.dp)
            AppBarTitleColor(context.resources.getString(R.string.app_name))
            HeightSpacer(height = 15.dp)
            AppBarTitleCustomColor(context.resources.getString(R.string.app_name),
                    ContextCompat.getColor(context, R.color.colorAccent))
            HeightSpacer(height = 15.dp)
            AppBarTitleIcon(context.resources.getString(R.string.app_name),
                    imageFromResource(context.resources,R.drawable.ic_menu_black_24dp))
            HeightSpacer(height = 15.dp)
            AppBarMenuIcon(text = context.resources.getString(R.string.app_name))
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    AppBar()
}
