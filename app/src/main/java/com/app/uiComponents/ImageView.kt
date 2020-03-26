package com.app.uiComponents

import androidx.annotation.DrawableRes
import androidx.compose.*
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.SimpleImage
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.vector.DrawVector
import androidx.ui.graphics.vector.VectorAsset
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.ripple.Ripple
import androidx.ui.material.surface.Surface
import androidx.ui.res.imageResource
import androidx.ui.res.vectorResource
import androidx.ui.unit.dp

@Composable
fun DrawableImage(@DrawableRes imageResourceId: Int,
                  modifier: Modifier = Modifier.None,
                  onClick: () -> Unit) {
    val image = imageResource(imageResourceId)
    Surface(modifier = modifier) {
        Clickable(onClick = onClick) {
            SimpleImage(image = image)
        }
    }
}

@Composable
fun VectorImageSelector(@DrawableRes vectorResourceId: Int,
                        modifier: Modifier = Modifier.None,
                        selected: Boolean = false,
                        alignment: Alignment = Alignment.Center,
                        iconColorOff : Int,
                        iconColorOn : Int,
                        onClick: () -> Unit) {
    val vector = vectorResource(vectorResourceId)
    val selectedColor = if (selected) {
        Color.Transparent
    } else {
        Color.Transparent
    }

    val tintColor = if (selected) {
        iconColorOn
    } else {
        iconColorOff
    }
    Surface(
        color = selectedColor,
        shape = RoundedCornerShape(4.dp),
        modifier = modifier + LayoutPadding(2.dp)
    ) {
        Ripple(bounded = true) {
            Clickable(onClick = onClick) {
                Container(width = vector.defaultWidth, height = vector.defaultHeight) {
                    DrawVector(
                        vectorImage = vector,
                        alignment = alignment,
                        tintColor = Color(tintColor)
                    )
                }
            }
        }
    }
}
@Composable
fun VectorImage(@DrawableRes vectorResourceId: Int,
                modifier: Modifier = Modifier.None,
                selected: Boolean = false,
                onClick: () -> Unit) {
    val vector = vectorResource(vectorResourceId)
    val colors = MaterialTheme.colors()
    val selectedColor = if (selected) {
        colors.primary
    } else {
        Color.Transparent
    }
    val selectedOnColor = if (selected) {
        colors.onPrimary
    } else {
        Color.Transparent
    }
    Surface(
        color = selectedColor,
        shape = RoundedCornerShape(4.dp),
        modifier = modifier + LayoutPadding(2.dp)
    ) {
        Ripple(bounded = true) {
            Clickable(onClick = onClick) {
                Container(width = vector.defaultWidth, height = vector.defaultHeight) {
                    DrawVector(
                        vectorImage = vector,
                        tintColor = selectedOnColor
                    )
                }
            }
        }
    }
}
