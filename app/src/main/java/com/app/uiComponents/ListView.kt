package com.app.uiComponents

import android.widget.Toast
import androidx.compose.Composable
import androidx.compose.ambient
import androidx.compose.unaryPlus
import androidx.ui.core.ContextAmbient
import androidx.ui.core.dp
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.ContainedButtonStyle
import androidx.ui.material.Divider
import com.app.helper.LaunchScreen
import com.app.jetpackcompose.R
/*
* @author Yash Agarwal
* 02.03.2020
* */

/**
 * Display Array of Columns in a form of ListView with TextView
 * @param arrayList The data to be displayed in each cell of the Columns.
 */

@Composable
fun <T> ListViewWithText(arrayList: ArrayList<T>) {
    val context = +ambient(ContextAmbient)
    VerticalScroller(isScrollable = true) {
        Column {
            arrayList.forEachIndexed { _, element ->
                Padding(padding = 12.dp) {
                    Clickable(onClick = {
                        Toast.makeText(context, R.string.click_response, Toast.LENGTH_SHORT)
                            .show()
                    }){
                        TextView(text = element)
                    }
                }
                Divider(color = Color.Black)
            }
        }
    }
}

/**
 * Display Array of Columns in a form of ListView with TextView and Button
 * @param arrayList The data to be displayed in each cell of the Columns.
 * @see Clickable Clicks on component whatever we put inside the lambda
 */

@Composable
fun <T> ListViewWithItemClick(arrayList: ArrayList<T>){
    val context = +ambient(ContextAmbient)
    VerticalScroller(isScrollable = true) {
        Padding(padding = 12.dp) {
            Column {
                arrayList.forEachIndexed { index, element ->
                    Clickable(onClick = {
                        Toast.makeText(context, R.string.click_response, Toast.LENGTH_SHORT).show()
                        if(index == 0) {
                            LaunchScreen.openActivity(context)
                        }
                    }) {
                        FlexRow(crossAxisAlignment = CrossAxisAlignment.Center){
                            //expanded is like weight Consume as full space allocated to it.
                            //flexible is like weight Consume the space base on View size
                            expanded(1f) {TextView(text = element)}
                            inflexible {//inflexible is like wrap_content
                                Button(
                                    text = context.resources.getString(R.string.open),
                                    style = ContainedButtonStyle(color = Color.LightGray),
                                    onClick = {
                                        Toast.makeText(context,"Click on $element Button", Toast.LENGTH_SHORT).show()
                                        if(index == 0) {
                                            LaunchScreen.openActivity(context)
                                        }
                                    },
                                    modifier = Spacing(12.dp)
                                )
                            }
                        }
                        Divider(color = Color.Black)
                    }
                }
            }
        }
    }
}

/**
 * Display Array of Columns in a form of ListView with TextView and Button
 * @param arrayList The data to be displayed in each cell of the Columns.
 * @see TextView 2 TextView added Vertically inside the Row.
 */

@Composable
fun <T> ListViewWith2TextView(arrayList: ArrayList<T>) {
    val context = +ambient(ContextAmbient)
    VerticalScroller(isScrollable = true) {
        Padding(padding = 12.dp) {
            Column {
                Clickable(onClick = {
                    Toast.makeText(context, R.string.click_response, Toast.LENGTH_SHORT).show()
                }){
                    arrayList.forEachIndexed { index, element ->
                        FlexRow(crossAxisAlignment = CrossAxisAlignment.Center) {
                            //expanded is like weight Consume as full space allocated to it.
                            //flexible is like weight Consume the space base on View size
                            expanded(1f) {
                                Column {
                                    TextView(text = element)
                                    TextView(text = element)
                                }
                            }
                            inflexible {//inflexible is like wrap_content
                                Button(
                                    text = context.resources.getString(R.string.open),
                                    style = ContainedButtonStyle(color = Color.LightGray),
                                    onClick = {
                                        Toast.makeText(context,"Click on $element Button",
                                            Toast.LENGTH_SHORT).show()
                                    },
                                    modifier = Spacing(12.dp)
                                )
                            }
                        }
                        Divider(color = Color.Black)
                    }
                }
            }
        }
    }
}