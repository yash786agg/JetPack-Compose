package com.app.uiComponents

import androidx.annotation.DrawableRes
import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.animation.Crossfade
import androidx.ui.core.LayoutModifier
import androidx.ui.core.Modifier
import androidx.ui.core.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.surface.Surface
import androidx.ui.text.TextStyle
import androidx.ui.text.style.TextAlign
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.app.helper.Screen
import com.app.helper.Status
import com.app.helper.navigateTo
import com.app.jetpackcompose.JetPackAppScreen
import com.app.jetpackcompose.JetPackUIComponents
import com.app.jetpackcompose.R

@Composable
fun NavigationDrawerMenu() {

    val (drawerState, onDrawerStateChange) = state { DrawerState.Closed }

    MaterialTheme{
        ModalDrawerLayout(
            drawerState = drawerState,
            onStateChange = onDrawerStateChange,
            gesturesEnabled = drawerState == DrawerState.Opened,
            drawerContent = {
                DrawerContent(
                    currentScreen = Status.currentScreen,
                    closeDrawer = { onDrawerStateChange(DrawerState.Closed) }
                )
            },
            bodyContent = { AppContent { onDrawerStateChange(DrawerState.Opened) } }
        )
    }
}

@Composable
private fun AppContent(openDrawer: () -> Unit) {
    Crossfade(Status.currentScreen) { screen ->
        Surface(color = (MaterialTheme.colors()).background) {
            when (screen) {
                is Screen.UIComponents -> JetPackUIComponents { openDrawer() }
                is Screen.JetPackApp -> JetPackAppScreen{ openDrawer() }
            }
        }
    }
}


@Composable
fun DrawerContent(currentScreen: Screen,
                  closeDrawer: () -> Unit) {

    Column(modifier = LayoutWidth.Fill + LayoutHeight.Fill) {
        DrawerButton(
            icon = R.drawable.ic_share_black_24dp,
            label = "UIComponents",
            isSelected = currentScreen == Screen.UIComponents
        ) {
            navigateTo(Screen.UIComponents)
            closeDrawer()
        }

        DrawerButton(
            icon = R.drawable.ic_more_black_24dp,
            label = "JetPackApp",
            isSelected = currentScreen == Screen.JetPackApp
        ) {
            navigateTo(Screen.JetPackApp)
            closeDrawer()
        }
    }
}

@Composable
private fun DrawerButton(
    modifier: Modifier = Modifier.None,
    @DrawableRes icon: Int,
    label: String,
    isSelected: Boolean,
    action: () -> Unit
) {
   // val context = ContextAmbient.current
    val colors = MaterialTheme.colors()
    val textIconColor = if (isSelected) {
        colors.primary
    } else {
        colors.onSurface.copy(alpha = 0.6f)
    }
    val backgroundColor = if (isSelected) {
        colors.primary.copy(alpha = 0.12f)
    } else {
        colors.surface
    }

    Surface(
        modifier = LayoutWidth.Fill + LayoutPadding(
            start = 8.dp,
            top = 8.dp,
            end = 8.dp
        ),
        color = backgroundColor,
        shape = RoundedCornerShape(4.dp)
    ) {
        Button(onClick = action) {
            Row(arrangement = Arrangement.Start) {

                VectorImage(vectorResourceId = icon) {
                    action()
                }

                Spacer(LayoutWidth(12.dp))

                TextViewStyling(
                    text = label,
                    style = TextStyle(
                        color = textIconColor,
                        textAlign = TextAlign.Start
                    )
                )
            }
        }
        /*TextButton(onClick = action) {
            Row(arrangement = Arrangement.Start) {
                VectorImage(
                    vectorResourceId = icon
                ){
                    action()
                }
                //Spacer(modifier = Modifier.None)
                Text(
                    text = label*//*,
                    style = (MaterialTheme.typography()).body2.copy(
                        color = textIconColor,
                        textAlign = TextAlign.Start
                    )*//*
                )
            }
        }*/
    }
}

@Preview
@Composable
fun preview() {
    DrawerContent(
        currentScreen = Status.currentScreen,
        closeDrawer = { }
    )
}