package com.example.spotifyclone.ui

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spotifyclone.R
import com.example.spotifyclone.data.LibraryItem
import com.example.spotifyclone.ui.theme.ScreenGrey
@Composable
fun LibraryScreen() {
    // Define your list of LibraryItems
    val libraryItems = listOf(
        LibraryItem("Liked Songs", R.drawable.like_song_ic),
        LibraryItem("New Episodes", R.drawable.new_episodes_ic),
        LibraryItem("Lolo Zouaï", R.drawable.lolo_zouai_ic),
        LibraryItem("Lana Del Rey", R.drawable.lana_ic),
        LibraryItem("Front Left", R.drawable.lolo_zouai_ic),
        LibraryItem("Marvin Gaye", R.drawable.lana_ic),
        LibraryItem("Les", R.drawable.lolo_zouai_ic)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ScreenGrey)
            .padding(8.dp)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
        Image(painter = painterResource(id = R.drawable.lolo_zouai_ic) , contentDescription ="Profile",Modifier.size(48.dp) )
        Spacer(modifier = Modifier.width(16.dp))
        Text("Your Library ", fontWeight = FontWeight.Bold ,color = Color.White,style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.width(LocalConfiguration.current.screenWidthDp.dp/4))
        Icon(imageVector = Icons.Default.Add, modifier = Modifier.size(64.dp),tint = Color.White ,contentDescription = "Add icon")
        }
        LazyRow(modifier = Modifier.padding(vertical = 8.dp)) {
            item {
                OutlinedButton(onClick = { /*TODO*/ },Modifier.padding(4.dp),contentPadding = PaddingValues(horizontal = 16.dp, vertical = 2.dp)
                ) {
                    Text("Playlists", color = Color.Gray, fontSize = 12.sp)

                }
            }
            item {
                OutlinedButton(onClick = { /*TODO*/ },Modifier.padding(4.dp),contentPadding = PaddingValues(horizontal = 16.dp, vertical = 2.dp) ) {
                    Text("Artists", color = Color.Gray, fontSize = 12.sp)
                }
            }
            item {
                OutlinedButton(onClick = { /*TODO*/ },Modifier.padding(4.dp),contentPadding = PaddingValues(horizontal = 16.dp, vertical = 2.dp)) {
                    Text("Albums", color = Color.Gray, fontSize = 12.sp)
                }
            }
            item {
                OutlinedButton(onClick = { /*TODO*/ },Modifier.padding(4.dp),contentPadding = PaddingValues(horizontal = 16.dp, vertical = 2.dp)) {
                    Text("Podcasts & shows", color = Color.Gray, fontSize = 12.sp)
                }
            }
        }


        // Recently played section
        Text(
            "Recently played",
            color = Color.Gray,
            fontSize = 12.sp,
            modifier = Modifier.padding(16.dp)
        )

        LazyColumn {
            items(libraryItems) { item ->
                LibraryItemRow(item = item)
            }
        }
    }
}

@Composable
fun LibraryItemRow(item: LibraryItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = item.iconResId),
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )
        Text(
            item.name,
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}
