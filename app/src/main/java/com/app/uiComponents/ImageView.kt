package com.app.uiComponents

import androidx.annotation.DrawableRes
import androidx.compose.*
import androidx.ui.core.*
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.DrawImage
import androidx.ui.graphics.Color
import androidx.ui.graphics.vector.DrawVector
import androidx.ui.layout.*
import androidx.ui.layout.Size
import androidx.ui.material.ripple.Ripple
import androidx.ui.res.imageResource
import androidx.ui.res.vectorResource

@Composable
fun DrawableImage(@DrawableRes id: Int, onClick: () -> Unit) {
    val image = +imageResource(id)
    Clickable(onClick = onClick) {
        Column(modifier = Size(image.width.dp, 180.dp)) {
            DrawImage(image = image)
        }
    }
}

@Composable
fun VectorDrawableImage(@DrawableRes id: Int, onClick: () -> Unit) {
    Ripple(bounded = false) {
        Clickable(onClick = onClick) {
            VectorImage(id = id)
        }
    }
}

@Composable
fun VectorImage(modifier: Modifier = Modifier.None, @DrawableRes id: Int, tint: Color = Color.Transparent) {
    val vector = +vectorResource(id)
    WithDensity {
        Container(modifier = modifier wraps Size(vector.defaultWidth.toDp(), vector.defaultHeight.toDp())) {
            DrawVector(vector, tint)
        }
    }
}