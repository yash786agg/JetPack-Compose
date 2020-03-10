package com.app.uiComponents

import androidx.annotation.DrawableRes
import androidx.compose.*
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.SimpleImage
import androidx.ui.graphics.Color
import androidx.ui.graphics.vector.DrawVector
import androidx.ui.layout.*
import androidx.ui.material.ripple.Ripple
import androidx.ui.res.imageResource
import androidx.ui.res.vectorResource

@Composable
fun DrawableImage(@DrawableRes id: Int, onClick: () -> Unit) {
    val image = imageResource(id)
    Clickable(onClick = onClick) {
        SimpleImage(image = image)
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
fun VectorImage(@DrawableRes id: Int, tint: Color = Color.Transparent) {
    val vector = vectorResource(id)
    Container(width = vector.defaultWidth, height = vector.defaultHeight) {
        DrawVector(vector, tint)
    }
}
