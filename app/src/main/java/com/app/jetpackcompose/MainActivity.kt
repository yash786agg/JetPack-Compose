package com.app.jetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.ContextAmbient
import androidx.ui.core.setContent
import androidx.ui.layout.Column
import androidx.ui.layout.LayoutWidth
import androidx.ui.layout.Stack
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import com.app.uiComponents.AppBarTitleIcon
import com.app.uiComponents.ListViewWithItemClick
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackCompose()
        }
    }
}

@Composable
fun JetPackCompose() = MaterialTheme {
    val context = ContextAmbient.current
    Column {
        AppBarTitleIcon(context.resources.getString(R.string.app_name),
            R.drawable.ic_menu_black_24dp) {
            Toast.makeText(context,"Click on Menu Drawer Icon", Toast.LENGTH_SHORT).show()
        }
        Stack(modifier = LayoutFlexible(1f) + LayoutWidth.Fill) {
            val arrayList = ArrayList<String>()
            arrayList.add(context.resources.getString(R.string.app_Bar))
            arrayList.add(context.resources.getString(R.string.text_view))
            arrayList.add(context.resources.getString(R.string.button))
            arrayList.add(context.resources.getString(R.string.image_view))
            arrayList.add(context.resources.getString(R.string.fab))
            for(i in 1..40){
                arrayList.add("${context.resources.getString(R.string.item)} $i")
            }
            ListViewWithItemClick(arrayList = arrayList)
        }
    }
}

@Preview
@Composable
fun DefaultPreview() = JetPackCompose()
