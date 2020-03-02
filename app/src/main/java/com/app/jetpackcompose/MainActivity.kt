package com.app.jetpackcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.ambient
import androidx.compose.unaryPlus
import androidx.ui.core.ContextAmbient
import androidx.ui.core.setContent
import androidx.ui.graphics.imageFromResource
import androidx.ui.layout.FlexColumn
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
    val context = +ambient(ContextAmbient)
    FlexColumn {
        inflexible {
            AppBarTitleIcon(context.resources.getString(R.string.app_name),
                    imageFromResource(context.resources,R.drawable.ic_menu_black_24dp))
        }
        flexible(1f) {
            val arrayList = ArrayList<String>()
            arrayList.add(context.resources.getString(R.string.app_Bar))
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
