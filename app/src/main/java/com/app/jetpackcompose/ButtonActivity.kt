package com.app.jetpackcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.ambient
import androidx.compose.unaryPlus
import androidx.core.content.ContextCompat
import androidx.ui.core.ContextAmbient
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.layout.Spacing
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import com.app.uiComponents.OutlineButtonStyle

class ButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyButtonView()
        }
    }
}

@Composable
fun MyButtonView() = MaterialTheme {
    val context = +ambient(ContextAmbient)
    VerticalScroller(isScrollable = true) {
        Column(Spacing(20.dp)) {
            OutlineButtonStyle(
                text = context.resources.getString(R.string.app_name),
                outLineColor = ContextCompat.getColor(context,R.color.colorRed),
                outLineWidth = 2,
                elevation = 16,
                textColor = ContextCompat.getColor(context,R.color.colorBlack),
                buttonColor = ContextCompat.getColor(context,R.color.colorWhite)
            )
        }
    }
}

@Preview
@Composable
fun ButtonPreView() = MyButtonView()