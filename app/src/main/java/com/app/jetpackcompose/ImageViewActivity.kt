package com.app.jetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.ambient
import androidx.compose.unaryPlus
import androidx.ui.core.ContextAmbient
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import com.app.uiComponents.DrawableImage
import com.app.uiComponents.VectorDrawableImage

class ImageViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyImageView()
        }
    }
}

@Composable
fun MyImageView() = MaterialTheme {
    val context = +ambient(ContextAmbient)

    Column(modifier = Expanded) {
        DrawableImage(R.drawable.debugging) {
            Toast.makeText(context,"Click on Drawable Image",Toast.LENGTH_SHORT).show()
        }

        HeightSpacer(height = 20.dp)

        VectorDrawableImage(R.drawable.ic_launcher_background) {
            Toast.makeText(context,"Click on Vector Image",Toast.LENGTH_SHORT).show()
        }
    }
}

@Preview
@Composable
fun ImageViewPreview(){
    MyImageView()
}