package com.app.helper

import androidx.compose.Model

sealed class Screen {
    object UIComponents : Screen()
    object JetPackApp : Screen()
}

@Model
object Status {
    var currentScreen: Screen = Screen.UIComponents
}

fun navigateTo(destination: Screen) {
    Status.currentScreen = destination
}
