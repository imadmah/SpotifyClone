package com.example.spotifyclone.data

import androidx.annotation.DrawableRes

data class AlbumItem(
    val name: String,
    @DrawableRes val iconResId: Int
)