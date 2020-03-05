package com.app.uiComponents

import androidx.compose.Composable
import androidx.ui.core.dp
import androidx.ui.foundation.shape.border.Border
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.SolidColor
import androidx.ui.layout.Height
import androidx.ui.layout.Spacing
import androidx.ui.layout.Width
import androidx.ui.material.Button
import androidx.ui.material.OutlinedButtonStyle

/*
* @author Yash Agarwal
* 05.03.2020
* */

/**
 * OutlineButtonStyle Button with out line text
 * @param text The text to be displayed in the Button.
 * @param outLineColor Border color.
 * @param outLineWidth Border width.
 * @param elevation Shadow below the button.
 * @param textColor Color reference used for the color of the button text.
 * @param buttonColor Color reference used for the button color.
 */

@Composable
fun OutlineButtonStyle(text: Any?,
                       outLineColor: Int,
                       outLineWidth: Int,
                       elevation: Int,
                       textColor: Int,
                       buttonColor: Int
) {

    Button(text = text.toString(),
        style = OutlinedButtonStyle
            (
                border = Border(brush = SolidColor(Color(color = outLineColor)),width = outLineWidth.dp),
                shape = RoundedCornerShape(50), //50% percent
                elevation = elevation.dp,
                contentColor = Color(color = textColor),
                color = Color(color = buttonColor)
            ),
        onClick = {},
        modifier = Spacing(12.dp)
    )
}