package com.app.helper

import android.content.Context
import android.content.Intent
import com.app.jetpackcompose.*

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
            3 -> {
                val intent = Intent(context, ImageViewActivity::class.java)
                context.startActivity(intent)
            }
            4 -> {
                val intent = Intent(context, FABActivity::class.java)
                context.startActivity(intent)
            }
        }
    }
}
