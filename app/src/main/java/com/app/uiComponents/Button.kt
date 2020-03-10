package com.app.uiComponents

import androidx.compose.Composable
import androidx.ui.foundation.Border
import androidx.ui.foundation.shape.corner.CornerSize
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.SolidColor
import androidx.ui.material.Button
import androidx.ui.material.OutlinedButton
import androidx.ui.material.TextButton
import androidx.ui.text.TextStyle
import androidx.ui.text.font.Font
import androidx.ui.text.font.FontFamily
import androidx.ui.unit.TextUnit
import androidx.ui.unit.dp

/*
* @author Yash Agarwal
* 05.03.2020
* */

/**
 * ButtonDefaultStyle provides all the required attributes for styling Button.
 * @param text The text to be displayed in the Button.
 * @param strokeColor Border color of the button.
 * @param strokeWidth Border width of the button.
 * @param buttonColor Color reference used for the button color.
 * @param roundCorner Width for Button corner.
 * @param textSize size of the button text font in Sp(Scalable Pixel) format
 * @param textColor Color reference used for text color.
 */

@Composable
fun ButtonDefaultStyle(text: Any?,
                       strokeColor: Int,
                       strokeWidth: Int = 1,
                       buttonColor: Int,
                       roundCorner: Int = 50,
                       textColor: Int,
                       onClick: () -> Unit
) {
    Button(backgroundColor = Color(color = buttonColor),
        contentColor = Color(color = textColor),
        shape = RoundedCornerShape(corner = CornerSize(roundCorner)),
        border = Border(size = strokeWidth.dp,brush = SolidColor(Color(color = strokeColor))),
        elevation = 16.dp,
        onClick = { onClick() }
    ){
        TextView(text = text.toString())
    }
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
                       roundCorner: Int = 50,
                       onClick: () -> Unit
) {

    OutlinedButton(
        backgroundColor = Color(color = buttonColor),
        border = Border(size = strokeWidth.dp,brush = SolidColor(Color(color = strokeColor))),
        shape = RoundedCornerShape(roundCorner), //50% percent
        elevation = elevation.dp,
        contentColor = Color(color = textColor),
        onClick = { onClick() }
    ){
        TextView(text = text.toString())
    }
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
fun ButtonTextStyle(text: Any?,
                    rippleColor: Int,
                    buttonColor: Int,
                    roundCorner: Int = 50,
                    strokeColor: Int,
                    strokeWidth: Int = 1,
                    elevation: Int = 1,
                    textColor: Int,
                    onClick: () -> Unit
) {

    TextButton(
        backgroundColor = Color(color = buttonColor),
        border = Border(size = strokeWidth.dp,brush = SolidColor(Color(color = strokeColor))),
        shape = RoundedCornerShape(roundCorner), //50% percent
        elevation = elevation.dp,
        contentColor = Color(color = textColor),
        onClick = { onClick() }
    ) {
        TextView(text = text.toString())
    }
}
