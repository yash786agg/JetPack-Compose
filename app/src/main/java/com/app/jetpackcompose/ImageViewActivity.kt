package com.app.jetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.ContextAmbient
import androidx.ui.core.setContent
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.app.uiComponents.DrawableImage
import com.app.uiComponents.VectorImage

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
    val context = ContextAmbient.current

    Column {
        DrawableImage(modifier = LayoutHeight(220.dp),imageResourceId = R.drawable.debugging) {
            Toast.makeText(context,"Click on Drawable Image",Toast.LENGTH_SHORT).show()
        }

        VectorImage(vectorResourceId = R.drawable.ic_launcher_background) {
            Toast.makeText(context,"Click on Vector Image",Toast.LENGTH_SHORT).show()
        }
    }
}

@Preview
@Composable
fun ImageViewPreview(){
    MyImageView()
}