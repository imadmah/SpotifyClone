package com.example.spotifyclone.data

import androidx.annotation.DrawableRes

data class LibraryItem(
    val name: String,
    val type: String,
    @DrawableRes val iconResId: Int
)
