package com.app.uiComponents

import android.text.style.LineHeightSpan
import androidx.annotation.DrawableRes
import androidx.compose.*
import androidx.ui.core.*
import androidx.ui.foundation.Clickable
import androidx.ui.graphics.Color
import androidx.ui.graphics.vector.DrawVector
import androidx.ui.layout.*
import androidx.ui.material.ripple.Ripple
import androidx.ui.res.imageResource
import androidx.ui.res.vectorResource
import androidx.ui.unit.dp

/*@Composable
fun DrawableImage(@DrawableRes id: Int, onClick: () -> Unit) {
    val vector = vectorResource(id)
    Clickable(onClick = onClick) {
        Column(modifier = LayoutSize(vector.defaultWidth,vector.defaultHeight)) {
            DrawVector(vectorImage = vector)
        }
    }
}*/

@Composable
fun VectorDrawableImage(@DrawableRes id: Int, onClick: () -> Unit) {
    val vector = vectorResource(id)
    Ripple(bounded = false) {
        Clickable(onClick = onClick) {
            DrawVector(vectorImage = vector)
        }
    }
}

/*
@Composable
fun VectorImage(modifier: Modifier = Modifier.None, @DrawableRes id: Int, tint: Color = Color.Transparent) {
    val vector = vectorResource(id)
    LineHeightSpan.WithDensity {
        Container(modifier = LayoutSize(vector.defaultWidth,vector.defaultHeight) {
            DrawVector(vector, tint)
        }
    }
}
*/
