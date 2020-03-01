package com.app.uiComponents

import android.widget.Toast
import androidx.compose.Composable
import androidx.compose.ambient
import androidx.compose.unaryPlus
import androidx.ui.core.ContextAmbient
import androidx.ui.graphics.Color
import androidx.ui.graphics.Image
import androidx.ui.graphics.imageFromResource
import androidx.ui.material.AppBarIcon
import androidx.ui.material.TopAppBar
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
        color = Color(color = color))
}

/**
 * App Bar displays title and Image Icon.
 * @param text The text to be displayed in the AppBar
 * @param image The image icon to be displayed at the start of the AppBar
 */

@Composable
fun AppBarTitleIcon(text: String, image: Image) {
    TopAppBar(title = {
        TextView(text)
    },
        color = Color.White,
        navigationIcon = {
            AppBarIcon(icon = image) {
                //Handle Click
            }
        })
}

/**
 * App Bar displays title and Menu Icon with Action.
 * @param text The text to be displayed in the AppBar.
 * Sealed Class MenuItem displays the list of Menu Icon
 * to be displayed at the end of App Bar.
 */

@Composable
fun AppBarMenuIcon(text: String) {
    val context = +ambient(ContextAmbient)
    TopAppBar(title = {
        TextView(text)

    },
        color = Color.Yellow,
        actionData = listOf(MenuItem.Share,MenuItem.More),
        action = {action ->
            AppBarIcon(icon = imageFromResource(context.resources,action.icon)) {
                when(action) {
                    MenuItem.Share -> {
                        Toast.makeText(context,"Click on Share",Toast.LENGTH_SHORT).show()
                    }
                    MenuItem.More -> {
                        Toast.makeText(context,"Click on More",Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    )
}