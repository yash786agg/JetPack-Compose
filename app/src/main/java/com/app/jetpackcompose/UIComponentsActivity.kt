package com.app.jetpackcompose

import android.os.Bundle
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
import com.app.uiComponents.NavigationDrawerMenu

class UIComponentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackUIComponents{}
        }
    }
}
@Composable
fun JetPackUIComponents(openDrawer: () -> Unit) = MaterialTheme {
    val context = ContextAmbient.current
    Column {
        AppBarTitleIcon(context.resources.getString(R.string.title_ui_components),
            R.drawable.ic_menu_black_24dp) {
            openDrawer()
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
fun JetPackUIComponentsPreview() = NavigationDrawerMenu()