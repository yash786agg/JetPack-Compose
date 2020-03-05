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
import androidx.ui.layout.Container
import androidx.ui.layout.HeightSpacer
import androidx.ui.layout.Spacing
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import com.app.uiComponents.*

class TextViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTextView()
        }
    }
}

@Composable
fun MyTextView() = MaterialTheme {
    val context = +ambient(ContextAmbient)

    VerticalScroller(isScrollable = true) {
        Column(modifier = Spacing(20.dp)) {
            TextView(text = context.resources.getString(R.string.app_name))
            HeightSpacer(height = 20.dp)
            Container(width = 180.dp) {
                TextView(text = context.resources.getString(R.string.jetPack_text))
            }
            HeightSpacer(height = 20.dp)
            TextViewMaxLines(text = context.resources.getString(R.string.jetPack_text),maxLines = 2)

            HeightSpacer(height = 20.dp)
            TexViewEllipsize(text = context.resources.getString(R.string.jetPack_text),maxLines = 2)

            HeightSpacer(height = 20.dp)
            TextViewStyling(
                text = context.resources.getString(R.string.jetPack_text),
                textColor = ContextCompat.getColor(context,R.color.colorBlack),
                textSize = 16,
                backgroundColor = ContextCompat.getColor(context,R.color.colorYellow),
                fountType = "deadpack.ttf")

            HeightSpacer(height = 20.dp)
            MultiColoredTextView(text = context.resources.getString(R.string.app_name),
                firstColor = ContextCompat.getColor(context,R.color.colorRed),
                textSize = 16,
                secondColor = ContextCompat.getColor(context,R.color.colorBlack)
            )

            HeightSpacer(height = 20.dp)
            MultiColoredParagraphTextView(text = context.resources.getString(R.string.jetPack_text),
                firstColor = ContextCompat.getColor(context,R.color.colorBlack),
                textSize = 18,
                secondColor = ContextCompat.getColor(context,R.color.colorRed),
                backgroundColor = ContextCompat.getColor(context,R.color.colorYellow),
                fountType = "berninasans_bold.ttf"
            )
        }
    }
}

@Preview
@Composable
fun TextViewPreview() =  MyTextView()