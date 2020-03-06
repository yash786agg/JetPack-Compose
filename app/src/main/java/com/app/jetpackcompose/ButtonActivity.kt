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
import androidx.ui.layout.HeightSpacer
import androidx.ui.layout.Spacing
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import com.app.uiComponents.ButtonContainedStyle
import com.app.uiComponents.ButtonDefaultStyle
import com.app.uiComponents.ButtonOutlineStyle

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
            ButtonDefaultStyle(
                text = context.resources.getString(R.string.app_name),
                strokeColor = ContextCompat.getColor(context,R.color.colorBlack),
                strokeWidth = 2,
                roundCorner = 30,
                rippleColor = ContextCompat.getColor(context,R.color.colorPrimary),
                buttonColor = ContextCompat.getColor(context,R.color.colorWhite),
                textColor = ContextCompat.getColor(context,R.color.colorRed),
                backgroundColor = ContextCompat.getColor(context,R.color.colorYellow),
                fountType = "berninasans_bold.ttf"
            )

            HeightSpacer(height = 20.dp)
            
            ButtonContainedStyle(
                text = context.resources.getString(R.string.app_name),
                rippleColor = ContextCompat.getColor(context,R.color.colorPrimary),
                buttonColor = ContextCompat.getColor(context,R.color.colorYellow),
                roundCorner = 20
            )

            HeightSpacer(height = 20.dp)

            ButtonOutlineStyle(
                text = context.resources.getString(R.string.app_name),
                strokeColor = ContextCompat.getColor(context,R.color.colorRed),
                strokeWidth = 2,
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