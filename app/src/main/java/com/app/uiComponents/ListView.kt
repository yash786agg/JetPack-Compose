package com.app.uiComponents

import android.widget.Toast
import androidx.compose.Composable
import androidx.ui.core.ContextAmbient
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.Divider
import androidx.ui.unit.dp
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
    val context = ContextAmbient.current
    VerticalScroller(isScrollable = true) {
        Column {
            arrayList.forEachIndexed { _, element ->
                Container(LayoutPadding(12.dp)) {
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
    val context = ContextAmbient.current
    VerticalScroller(isScrollable = true) {
        Container(LayoutPadding(12.dp)) {
            Column {
                arrayList.forEachIndexed { index, element ->
                    Clickable(onClick = {
                        Toast.makeText(context, R.string.click_response, Toast.LENGTH_SHORT).show()
                        LaunchScreen.openActivity(index,context)

                    }) {
                        Row(modifier = LayoutPadding(12.dp)) {
                            Stack(modifier = LayoutFlexible(1f) + LayoutGravity.Center) { TextView(text = element) }
                            Stack(modifier = LayoutFlexible(1f) + LayoutWidth.Fill + LayoutAlign.End) {
                                Button(
                                    onClick = {
                                        Toast.makeText(context,"Click on $element Button", Toast.LENGTH_SHORT).show()
                                        LaunchScreen.openActivity(index,context)
                                    }
                                ){
                                    TextView(text = context.resources.getString(R.string.open))
                                }
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
    val context = ContextAmbient.current
    VerticalScroller(isScrollable = true) {
        Container(LayoutPadding(12.dp)) {
            Column {
                Clickable(onClick = {
                    Toast.makeText(context, R.string.click_response, Toast.LENGTH_SHORT).show()
                }){
                    arrayList.forEachIndexed { index, element ->
                        Row(modifier = LayoutPadding(12.dp)) {
                            Stack(modifier = LayoutFlexible(1f) + LayoutGravity.Center){
                                Column {
                                    TextView(text = element)
                                    TextView(text = element)
                                }
                            }
                            Stack(modifier = LayoutFlexible(1f) + LayoutWidth.Fill + LayoutAlign.End) {//inflexible is like wrap_content
                                Button(
                                    onClick = {
                                        Toast.makeText(context,"Click on $element Button",
                                            Toast.LENGTH_SHORT).show()
                                    }
                                ){
                                    TextView(text = context.resources.getString(R.string.open))
                                }
                            }
                        }
                        Divider(color = Color.Black)
                    }
                }
            }
        }
    }
}
