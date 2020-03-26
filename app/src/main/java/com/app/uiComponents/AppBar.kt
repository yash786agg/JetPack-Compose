package com.app.uiComponents

import androidx.annotation.DrawableRes
import androidx.compose.Composable
import androidx.ui.graphics.Color
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.LayoutWidth
import androidx.ui.material.TopAppBar
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
 */

@Composable
fun AppBarTitleIcon(text: String, @DrawableRes id: Int, onClick: () -> Unit) {
    TopAppBar(title = {
        TextView(text)
    },
        color = Color.Yellow,
        navigationIcon = {
            VectorImage(
                modifier = LayoutWidth(32.dp) + LayoutHeight(32.dp),
                vectorResourceId = id,
                onClick = onClick
            )
        })
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
                VectorImage(
                    modifier = LayoutWidth(32.dp) + LayoutHeight(32.dp),
                    vectorResourceId = action.icon,
                    onClick = { onClick(action) }
                )
            }
        }
    )
}
