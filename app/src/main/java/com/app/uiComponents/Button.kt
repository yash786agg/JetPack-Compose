package com.app.uiComponents

import androidx.compose.Composable
import androidx.ui.core.TextUnit
import androidx.ui.core.dp
import androidx.ui.foundation.shape.border.Border
import androidx.ui.foundation.shape.corner.CornerSize
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.SolidColor
import androidx.ui.material.Button
import androidx.ui.material.ButtonStyle
import androidx.ui.material.ContainedButtonStyle
import androidx.ui.material.OutlinedButtonStyle
import androidx.ui.text.TextStyle
import androidx.ui.text.font.Font
import androidx.ui.text.font.FontFamily

/*
* @author Yash Agarwal
* 05.03.2020
* */

/**
 * ButtonDefaultStyle provides all the required attributes for styling Button.
 * @param text The text to be displayed in the Button.
 * @param strokeColor Border color of the button.
 * @param strokeWidth Border width of the button.
 * @param rippleColor when pressed the color of the ripple effect.
 * @param buttonColor Color reference used for the button color.
 * @param roundCorner Width for Button corner.
 * @param textSize size of the button text font in Sp(Scalable Pixel) format
 * @param textColor Color reference used for text color.
 * @param backgroundColor background color of the text component
 * @param fountType to format text in a defined formatted font.
 */

@Composable
fun ButtonDefaultStyle(text: Any?,
                       strokeColor: Int,
                       strokeWidth: Int = 1,
                       rippleColor: Int,
                       buttonColor: Int,
                       roundCorner: Int = 50,
                       textSize: Int = 14,
                       textColor: Int,
                       backgroundColor: Int,
                       fountType: String
) {

    val textStyle = TextStyle(
        color = Color(color = textColor),
        fontSize = TextUnit.Sp(textSize),
        background = Color(color = backgroundColor),
        fontFamily = FontFamily(Font(name = fountType))
    )

    Button(text = text.toString(),
        style = ButtonStyle(
            color = Color(color = buttonColor),
            shape = RoundedCornerShape(corner = CornerSize(roundCorner)),
            border = Border(brush = SolidColor(Color(color = strokeColor)),width = strokeWidth.dp),
            elevation = 16.dp,
            rippleColor = Color(color = rippleColor),
            textStyle = textStyle
        ),
        onClick = {}
    )
}

/**
 * ButtonOutlineStyle draws the button with outline stroke and body.
 * @param text The text to be displayed in the Button.
 * @param strokeColor Border color of the button.
 * @param strokeWidth Border width of the button.
 * @param elevation Shadow below the button.
 * @param textColor Color reference used for the color of the button text.
 * @param buttonColor Color reference used for the button color.
 * @param roundCorner Width for Button corner.
 */

@Composable
fun ButtonOutlineStyle(text: Any?,
                       strokeColor: Int,
                       strokeWidth: Int = 1,
                       elevation: Int = 1,
                       textColor: Int,
                       buttonColor: Int,
                       roundCorner: Int = 50
) {

    Button(text = text.toString(),
        style = OutlinedButtonStyle
            (
                border = Border(brush = SolidColor(Color(color = strokeColor)),width = strokeWidth.dp),
                shape = RoundedCornerShape(roundCorner), //50% percent
                elevation = elevation.dp,
                contentColor = Color(color = textColor),
                color = Color(color = buttonColor)
            ),

        onClick = {}
    )
}

/**
 * ButtonContainedStyle is the standard style of buttons, it’s also the default style that is
 * applied to the Button component
 * @param text The text to be displayed in the Button.
 * @param rippleColor when pressed the color of the ripple effect.
 * @param buttonColor Color reference used for the button color.
 * @param roundCorner Width for Button corner.
 */

@Composable
fun ButtonContainedStyle(text: Any?,
                         rippleColor: Int,
                         buttonColor: Int,
                         roundCorner: Int = 50
) {

    Button(text = text.toString(),
        style = ContainedButtonStyle(
            shape = RoundedCornerShape(corner = CornerSize(roundCorner)),
            elevation = 16.dp,
            rippleColor = Color(color = rippleColor),
            color = Color(color = buttonColor)
        ),
        onClick = {}
    )
}