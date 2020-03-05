package com.app.helper

import android.content.Context
import android.content.Intent
import com.app.jetpackcompose.AppBarActivity
import com.app.jetpackcompose.ButtonActivity
import com.app.jetpackcompose.TextViewActivity

object LaunchScreen {
    fun openActivity(index: Int,context: Context) {
        when(index) {
            0 -> {
                val intent = Intent(context, AppBarActivity::class.java)
                context.startActivity(intent)
            }
            1 -> {
                val intent = Intent(context, TextViewActivity::class.java)
                context.startActivity(intent)
            }
            2 -> {
                val intent = Intent(context, ButtonActivity::class.java)
                context.startActivity(intent)
            }
        }

    }
}