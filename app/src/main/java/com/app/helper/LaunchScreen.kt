package com.app.helper

import android.content.Context
import android.content.Intent
import com.app.jetpackcompose.AppBarActivity

object LaunchScreen {
    fun openActivity(context: Context) {
        val intent = Intent(context, AppBarActivity::class.java)
        context.startActivity(intent)
    }
}