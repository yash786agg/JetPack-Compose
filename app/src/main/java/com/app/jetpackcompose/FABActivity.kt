package com.app.jetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.core.content.ContextCompat
import androidx.ui.core.ContextAmbient
import androidx.ui.core.setContent
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.app.uiComponents.FABCustomizeIcon
import com.app.uiComponents.FABIcon
import com.app.uiComponents.FABIconText
import com.app.uiComponents.FABText

class FABActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFAB()
        }
    }
}

@Composable
fun MyFAB() = MaterialTheme {
    val context = ContextAmbient.current
    Column {
        Stack(modifier = LayoutFlexible(1f) + LayoutWidth.Fill) {
            Container(modifier = LayoutGravity.BottomEnd) {
                FABIconText(modifier = LayoutPadding(16.dp),
                    onClick = {
                        Toast.makeText(context,"Click on FABIconText", Toast.LENGTH_SHORT).show()
                    },
                    fabColor = ContextCompat.getColor(context,R.color.colorYellow),
                    vectorResourceId = R.drawable.ic_share_black_24dp,
                    text = context.resources.getText(R.string.share),
                    textSize = 16,
                    textColor = ContextCompat.getColor(context,R.color.colorBlack))
            }

            Column(modifier = LayoutPadding(20.dp)) {
                FABText(
                    onClick = {
                        Toast.makeText(context,"Click on FABText Icon", Toast.LENGTH_SHORT).show()
                    },
                    fabColor = ContextCompat.getColor(context,R.color.colorYellow),
                    text = context.resources.getText(R.string.share),
                    textSize = 16,
                    textColor = ContextCompat.getColor(context,R.color.colorBlack)
                )

                Spacer(modifier = LayoutHeight(height = 10.dp))

                Container(LayoutPadding(10.dp)) {
                    FABIcon(
                        onClick = {
                            Toast.makeText(context,"Click on FABIcon", Toast.LENGTH_SHORT).show()
                        },
                        fabColor = ContextCompat.getColor(context,R.color.colorYellow),
                        vectorResourceId = R.drawable.ic_share_black_24dp
                    )
                }

                Spacer(modifier = LayoutHeight(height = 10.dp))

                Container(LayoutPadding(10.dp)) {
                    FABIcon(
                        onClick = {
                            Toast.makeText(context,"Click on FABIcon", Toast.LENGTH_SHORT).show()
                        },
                        fabColor = ContextCompat.getColor(context,R.color.colorYellow),
                        vectorResourceId = R.drawable.ic_share_black_24dp,
                        roundCorner = 20
                    )
                }

                Spacer(modifier = LayoutHeight(height = 10.dp))

                Container(LayoutPadding(10.dp)) {
                    FABCustomizeIcon(
                        onClick = {
                            Toast.makeText(context,"Click on FABIcon", Toast.LENGTH_SHORT).show()
                        },
                        fabColor = ContextCompat.getColor(context,R.color.colorYellow),
                        vectorResourceId = R.drawable.ic_share_black_24dp,
                        roundCorner = 50,
                        strokeColor = ContextCompat.getColor(context,R.color.colorBlack),
                        strokeWidth = 2
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun FABPreview() =  MyFAB()