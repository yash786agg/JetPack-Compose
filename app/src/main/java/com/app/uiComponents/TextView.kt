package com.app.uiComponents

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.Text
import androidx.ui.foundation.Clickable
import androidx.ui.graphics.Color
import androidx.ui.text.AnnotatedString
import androidx.ui.text.SpanStyle
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontFamily
import androidx.ui.text.font.FontStyle
import androidx.ui.text.style.TextAlign
import androidx.ui.text.style.TextDecoration
import androidx.ui.text.style.TextOverflow
import androidx.ui.unit.TextUnit
import androidx.ui.unit.sp

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
fun TextViewMaxLines(text: Any?, maxLines: Int = 1) {
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
fun TexViewEllipsize(text: Any?, maxLines: Int = 1) {
    Text(
        text = text.toString(),
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis
    )
}

/**
 * TextViewStyling to style the text attribute.
 * @param text The text to be displayed

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
        modifier: Modifier = Modifier.None,
        style: TextStyle)
{
    Text(
        text = text.toString(),
        modifier = modifier,
        style = style
    )
}

/**
 * MultiColoredTextView to display text with 2 or more color on the screen.
 * @param text The text to be displayed
 * @param firstColor Color reference used for the color of the first text part
 * @param textSize size of the text font in Sp(Scalable Pixel) format
 * @param secondColor Color reference used for the color of the second text part
 * AnnotatedString is used when we want to provide styled text that utilises spans / multiple text styles.
 */


@Composable
fun MultiColoredTextView(text: Any?,
                         firstColor: Int,
                         textSize: Int = 14,
                         secondColor: Int) {

    val annotatedString = AnnotatedString.Builder(text.toString())
        .apply {
            addStyle(
                SpanStyle(color = Color(color = firstColor),
                        textDecoration = TextDecoration.LineThrough,
                        fontSize = 18.sp,
                        fontStyle = FontStyle.Italic), 0, 7)
        }

    Text(
        text = annotatedString.toAnnotatedString(),
        style = TextStyle(
            color = Color(color = secondColor),
            fontSize = TextUnit.Sp(textSize),
            fontStyle = FontStyle.Italic
        )
    )
}

/**
 * MultiColoredParagraphTextView to display text in paragraph with different
 * style, color and appearance on the screen.
 * @param text The text to be displayed
 * @param firstColor Color reference used for the color of the first text part
 * @param textSize size of the text font in Sp(Scalable Pixel) format
 * @param secondColor Color reference used for the color of the second text part
 * @param backgroundColor background color of the text component
 * ParagraphStyle is used to provide styles for the paragraphs of the text component
 * pushStyle() - The style will be applied to any text that is appended after the style
 * has been pushed.
 * popStyle() – It removes the previously added style from the AnnotatedText.
 */


@Composable
fun MultiColoredParagraphTextView(text: Any?,
                                  firstColor: Int,
                                  textSize: Int = 14,
                                  secondColor: Int,
                                  backgroundColor: Int) {
    val spanStyle = SpanStyle(
        color = Color(color = firstColor),
        fontSize = TextUnit.Sp(textSize),
        background = Color(color = backgroundColor),
        fontFamily = FontFamily.SansSerif
    )
    val annotatedString = AnnotatedString.Builder(text.toString().substring(0, 19))
    annotatedString.pushStyle(spanStyle)
    annotatedString.append(text.toString().substring(19, 94))
    annotatedString.popStyle()
    annotatedString.append(text.toString().substring(94, text.toString().length))

    Text(
        text = annotatedString.toAnnotatedString(),
        style = TextStyle(
            color = Color(color = secondColor),
            fontSize = 16.sp,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Start,
            lineHeight = 26.sp
        )
    )
}

/**
 * TextView to display some text on screen
 * @param text The text to be displayed
 * @param onClick Click listener on TextView
 */

@Composable
fun TextViewClick(text: Any?,
                  onClick: () -> Unit) {
    Clickable(onClick = onClick) {
        Text(text = text.toString())
    }
}
