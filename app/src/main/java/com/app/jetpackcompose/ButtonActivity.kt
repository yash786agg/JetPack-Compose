package com.app.jetpackcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.core.content.ContextCompat
import androidx.ui.core.ContextAmbient
import androidx.ui.core.setContent
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.LayoutPadding
import androidx.ui.layout.Spacer
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.app.uiComponents.ButtonDefaultStyle
import com.app.uiComponents.ButtonOutlineStyle
import com.app.uiComponents.ButtonTextStyle

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
    val context = ContextAmbient.current
    VerticalScroller(isScrollable = true) {
        Column(LayoutPadding(20.dp)) {
            ButtonDefaultStyle(
                text = context.resources.getString(R.string.app_name),
                strokeColor = ContextCompat.getColor(context,R.color.colorBlack),
                strokeWidth = 2,
                roundCorner = 30,
                buttonColor = ContextCompat.getColor(context,R.color.colorWhite),
                textColor = ContextCompat.getColor(context,R.color.colorRed)
            ){
                // Handle Click
            }

            Spacer(modifier = LayoutHeight(height = 20.dp))

            ButtonTextStyle(
                text = context.resources.getString(R.string.app_name),
                rippleColor = ContextCompat.getColor(context,R.color.colorPrimary),
                buttonColor = ContextCompat.getColor(context,R.color.colorYellow),
                roundCorner = 20,
                strokeColor = ContextCompat.getColor(context,R.color.colorRed),
                strokeWidth = 2,
                textColor = ContextCompat.getColor(context,R.color.colorBlack)
            ){
                // Handle Click
            }

            Spacer(modifier = LayoutHeight(height = 20.dp))

            ButtonOutlineStyle(
                text = context.resources.getString(R.string.app_name),
                strokeColor = ContextCompat.getColor(context,R.color.colorRed),
                strokeWidth = 2,
                elevation = 16,
                textColor = ContextCompat.getColor(context,R.color.colorBlack),
                buttonColor = ContextCompat.getColor(context,R.color.colorWhite)
            ){
                // Handle Click
            }
        }
    }
}

@Preview
@Composable
fun ButtonPreView() = MyButtonView()