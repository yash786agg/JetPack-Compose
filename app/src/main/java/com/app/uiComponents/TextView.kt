package com.app.uiComponents

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.TextUnit
import androidx.ui.graphics.Color
import androidx.ui.text.TextStyle
import androidx.ui.text.font.Font
import androidx.ui.text.font.FontFamily
import androidx.ui.text.font.FontStyle
import androidx.ui.text.style.TextDecoration
import androidx.ui.text.style.TextOverflow

/*
* @author Yash Agarwal
* 04.03.2020
* */

/**
 * TextView to display some text on screen
 * @param text The text to be displayed
 */

@Composable
fun TextView(text: Any?) = Text(text = text.toString())

/**
 * TextViewMaxLines to display some text on screen with a limit of maximum lines
 * @param text The text to be displayed
 * @param maxLines Declare the maximum number of lines that can be displayed for the text component
 */

@Composable
fun TextViewMaxLines(text: Any?, maxLines: Int? = 1) {
    Text(
        text = text.toString(),
        maxLines = maxLines
    )
}

/**
 * TexViewEllipsize to display some overflowed text on screen.
 * @param text The text to be displayed
 * @param maxLines Declare the maximum number of lines that can be displayed for the text component
 * overflow = TextOverflow.Ellipsis text will display ellipsis (…)
 */

@Composable
fun TexViewEllipsize(text: Any?, maxLines: Int? = 1) {
    Text(
        text = text.toString(),
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis
    )
}

/**
 * TextViewStyling to style the text attribute.
 * @param text The text to be displayed
 * @param textColor Color reference used for the color of the text
 * @param textSize size of the text font in Sp(Scalable Pixel) format
 * @param backgroundColor background color of the text component
 *
 * Other decoration -> TextDecoration.None =  Hello
 * TextDecoration.LineThrough = Hello
 *
 * fontFamily the font family to be used for the text
 * @sample
 * val SansSerif = FontFamily("sans-serif")
   val Serif = FontFamily("serif")
   val Monospace = FontFamily("monospace")
   val Cursive = FontFamily("cursive")

  Custom font

  Download any font you like from https://fonts.google.com/ then place it inside res/font folder.
  if you don't see it go to res folder right click it and click “new” goto “Android Resource
  Directory” in directory name type the word “font” and at the resource type select “fonts”

  Paste the font there preferably in .otf or .ttf format and rename files into small letters
  and underscores
 */

@Composable
fun TextViewStyling(
        text: Any?,
        textColor: Int,
        textSize: Int = 14,
        backgroundColor: Int,
        fountType: String)
{
    Text(
        text = text.toString(),
        style = TextStyle(
            color =  Color(color = textColor),
            fontSize = TextUnit.Sp(textSize),
            background = Color(color = backgroundColor),
            fontFamily = FontFamily(Font(name = fountType)),
            fontStyle = FontStyle.Normal,
            decoration = TextDecoration.Underline
        )
    )
}