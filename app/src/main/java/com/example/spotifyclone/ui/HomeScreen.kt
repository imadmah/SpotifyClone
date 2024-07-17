package com.example.spotifyclone

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spotifyclone.ui.theme.ScreenGrey2

@Composable
fun HomeScreen(onAlbumClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ScreenGrey2)
            .verticalScroll(rememberScrollState())
    ) {

        Text(text = "Recently Played", Modifier
            .align(Alignment.Start)
            .padding(16.dp)    ,
            Color.White,
            fontSize=20.sp
        )
        // Recently played section
        Row(modifier = Modifier.padding(horizontal = 16.dp)) {
            AlbumItem(onClick = onAlbumClick)
            AlbumItem(onClick = onAlbumClick)
            AlbumItem(onClick = onAlbumClick)
        }

        // Your 2021 in review section
        Text("Your 2021 in review", color = Color.White, fontSize = 20.sp, modifier = Modifier.padding(16.dp))
        Row(modifier = Modifier.padding(16.dp)) {
            Image(painter = painterResource(id = R.drawable.cover1), contentDescription = null, modifier = Modifier.size(120.dp))
            Spacer(modifier = Modifier.size(16.dp))
            Image(painter = painterResource(id = R.drawable.cover2), contentDescription = null, modifier = Modifier.size(120.dp))
        }

        // Editor's picks section
        Text("Editor's picks", color = Color.White, fontSize = 20.sp, modifier = Modifier.padding(16.dp))
        Row(modifier = Modifier.padding(horizontal = 16.dp)) {
            AlbumItem(onClick = onAlbumClick)
            AlbumItem(onClick = onAlbumClick)
            AlbumItem(onClick = onAlbumClick)
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun AlbumItem(onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.cover5), contentDescription = null, modifier = Modifier.size(100.dp))
        Text("Album", color = Color.White, fontSize = 12.sp, modifier = Modifier.padding(top = 4.dp))
    }
}
