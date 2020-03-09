package com.app.jetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.core.content.ContextCompat
import androidx.ui.core.*
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.app.helper.MenuItem
import com.app.uiComponents.*

class AppBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppBar()
        }
    }
}

@Composable
fun MyAppBar() = MaterialTheme {
    val context = ContextAmbient.current
    Column {
        AppBarTitle(context.resources.getString(R.string.app_name))

        Spacer(modifier = LayoutHeight(15.dp))

        AppBarTitleColor(context.resources.getString(R.string.app_name))

        Spacer(modifier = LayoutHeight(15.dp))

        AppBarTitleCustomColor(context.resources.getString(R.string.app_name),
            ContextCompat.getColor(context, R.color.colorAccent))

        Spacer(modifier = LayoutHeight(15.dp))

        AppBarTitleIcon(context.resources.getString(R.string.app_name),R.drawable.ic_menu_black_24dp) {
            Toast.makeText(context,"Click on Menu Drawer Icon",Toast.LENGTH_SHORT).show()
        }
        Spacer(modifier = LayoutHeight(15.dp))
        AppBarMenuIcon(text = context.resources.getString(R.string.app_name)) {
            when(it) {
                MenuItem.Share -> {
                    Toast.makeText(context,"Click on Share",Toast.LENGTH_SHORT).show()
                }
                MenuItem.More -> {
                    Toast.makeText(context,"Click on More",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

@Preview
@Composable
fun AppBarPreview() =  MyAppBar()