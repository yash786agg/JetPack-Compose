package com.app.helper

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.app.jetpackcompose.R

sealed class MenuItem(@StringRes val label: Int, @DrawableRes val icon: Int) {
    object Share: MenuItem(R.string.share,R.drawable.ic_share_black_24dp)
    object More: MenuItem(R.string.more,R.drawable.ic_more_black_24dp)
}