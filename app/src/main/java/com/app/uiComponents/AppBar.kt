package com.app.uiComponents

import androidx.annotation.DrawableRes
import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.vector.DrawVector
import androidx.ui.graphics.vector.VectorAsset
import androidx.ui.layout.Container
import androidx.ui.layout.LayoutPadding
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import androidx.ui.material.ripple.Ripple
import androidx.ui.material.surface.Surface
import androidx.ui.res.vectorResource
import androidx.ui.unit.dp
import com.app.helper.MenuItem

/*
* @author Yash Agarwal
* 01.03.2020
* */

/**
 * App Bar displays only a title.
 * @param text The text to be displayed in the AppBar
 */
@Composable
fun AppBarTitle(text: String) {
    TopAppBar(title = { TextView(text) })
}

/**
 * App Bar with title and Color
 * @param text The text to be displayed in the AppBar
 */
@Composable
fun AppBarTitleColor(text: String) {
    TopAppBar(title = { TextView(text) },
        color = Color.Gray)
}

/**
 * App Bar with title and Custom Color.
 * @param text The text to be displayed in the AppBar
 * @param color A custom color for the AppBar
 */
@Composable
fun AppBarTitleCustomColor(text: String, color: Int) {
    TopAppBar(title = { TextView(text) },
        color = Color(color = color)
    )
}

/**
 * App Bar displays title and Image Icon.
 * @param text The text to be displayed in the AppBar
 * @param image The image icon to be displayed at the start of the AppBar
 */

@Composable
fun AppBarTitleIcon(text: String, @DrawableRes id: Int, onClick: () -> Unit) {
    TopAppBar(title = {
        TextView(text)
    },
        color = Color.Yellow,
        navigationIcon = {
            IconButton(
                vectorResourceId = id,
                onClick = onClick
            )
        })
}

@Composable
fun IconButton(
    modifier: Modifier = Modifier.None,
    @DrawableRes vectorResourceId: Int,
    selected: Boolean = false,
    onClick: () -> Unit
) {
    val vector = vectorResource(vectorResourceId)
    IconButton(modifier, vector, selected, onClick)
}

@Composable
fun IconButton(
    modifier: Modifier = Modifier.None,
    iconVector: VectorAsset,
    selected: Boolean = false,
    onClick: () -> Unit
) {
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
                Container(width = 32.dp, height = 32.dp) {
                    DrawVector(
                        vectorImage = iconVector,
                        tintColor = selectedOnColor
                    )
                }
            }
        }
    }
}

/**
 * App Bar displays title and Menu Icon with Action.
 * @param text The text to be displayed in the AppBar.
 * Sealed Class MenuItem displays the list of Menu Icon
 * to be displayed at the end of App Bar.
 */

@Composable
fun AppBarMenuIcon(text: String,onClick:(MenuItem) -> Unit) {

    TopAppBar(title = { TextView(text) },
        color = Color.White,
        actions =
        {
            listOf(MenuItem.Share,MenuItem.More).forEach { action ->
                IconButton(
                    vectorResourceId = action.icon,
                    onClick = { onClick(action) }
                )
            }
        }
    )
}
