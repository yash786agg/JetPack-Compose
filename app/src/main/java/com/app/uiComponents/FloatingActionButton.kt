package com.app.uiComponents

import androidx.annotation.DrawableRes
import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.Text
import androidx.ui.foundation.Border
import androidx.ui.foundation.DrawBorder
import androidx.ui.foundation.shape.corner.CornerSize
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.SolidColor
import androidx.ui.layout.*
import androidx.ui.material.FloatingActionButton
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontFamily
import androidx.ui.text.font.FontStyle
import androidx.ui.unit.TextUnit
import androidx.ui.unit.dp

@Composable
fun FABIconText(modifier: Modifier = Modifier.None,
            @DrawableRes vectorResourceId: Int,
            onClick: () -> Unit,
            elevation : Int = 6,
            fabColor: Int,
            roundCorner: Int = 50,
            text: Any?,
            textColor: Int,
            textSize: Int = 14
) {
    FloatingActionButton(modifier = modifier,
        elevation = elevation.dp,
        onClick = onClick,
        color = Color(color = fabColor),
        shape = RoundedCornerShape(corner = CornerSize(roundCorner)) // RectangleShape or  CircleShape  -> for Rectangle or Circle Shape
    ) {
        Row(LayoutPadding(start = 12.dp, end = 20.dp)) {
            VectorImage(vectorResourceId = vectorResourceId,
                onClick = onClick
            )
            Spacer(LayoutWidth(12.dp))
            TextViewStyling(
                modifier = LayoutGravity.Center,
                text = text.toString(),
                style = TextStyle(
                    color =  Color(color = textColor),
                    fontSize = TextUnit.Sp(textSize),
                    fontFamily = FontFamily.SansSerif,
                    fontStyle = FontStyle.Normal
                )
            )
        }
    }
}

@Composable
fun FABText(modifier: Modifier = Modifier.None,
                onClick: () -> Unit,
                elevation : Int = 6,
                fabColor: Int,
                roundCorner: Int = 50, // RectangleShape or  CircleShape  -> for Rectangle or Circle Shape
                text: Any?,
                textColor: Int,
                textSize: Int = 14
) {
    FloatingActionButton(modifier = modifier,
        elevation = elevation.dp,
        onClick = onClick,
        color = Color(color = fabColor),
        shape = RoundedCornerShape(corner = CornerSize(roundCorner))
    ) {
        Row(LayoutPadding(start = 12.dp, end = 20.dp)) {
            Spacer(LayoutWidth(12.dp))
            Text(
                modifier = LayoutGravity.Center,
                text = text.toString(),
                style = TextStyle(
                    color =  Color(color = textColor),
                    fontSize = TextUnit.Sp(textSize),
                    fontFamily = FontFamily.SansSerif,
                    fontStyle = FontStyle.Normal
                )
            )
        }
    }
}

@Composable
fun FABIcon(modifier: Modifier = Modifier.None,
                @DrawableRes vectorResourceId: Int,
                onClick: () -> Unit,
                roundCorner: Int = 50,
                elevation : Int = 6,
                fabColor: Int
) {
    FloatingActionButton(modifier = modifier,
        elevation = elevation.dp,
        onClick = onClick,
        color = Color(color = fabColor),
        shape = RoundedCornerShape(corner = CornerSize(roundCorner)) // RectangleShape or  CircleShape  -> for Rectangle or Circle Shape
    ) {
        VectorImage(vectorResourceId = vectorResourceId,
            onClick = onClick
        )
    }
}

@Composable
fun FABCustomizeIcon(@DrawableRes vectorResourceId: Int,
            onClick: () -> Unit,
            roundCorner: Int = 50,
            strokeColor: Int,
            strokeWidth: Int = 0,
            elevation : Int = 6,
            fabColor: Int
) {
    FloatingActionButton(modifier = DrawBorder(
        border = Border(size = strokeWidth.dp,brush = SolidColor(Color(color = strokeColor))),
        shape = RoundedCornerShape(corner = CornerSize(roundCorner)) // RectangleShape or  CircleShape  -> for Rectangle or Circle Shape
    ),
        elevation = elevation.dp,
        onClick = onClick,
        color = Color(color = fabColor)
    ) {
        VectorImage(vectorResourceId = vectorResourceId,
            onClick = onClick
        )
    }
}

