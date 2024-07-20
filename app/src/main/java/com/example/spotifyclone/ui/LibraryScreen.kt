package com.example.spotifyclone.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.spotifyclone.R
import com.example.spotifyclone.data.LibraryItem
import com.example.spotifyclone.ui.theme.ScreenGrey



@Preview(showBackground = true)
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
    val libraryFilters = listOf(
        "Playlists",
        "Artists",
        "Albums",
        "Podcasts & shows"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ScreenGrey)
            .padding(8.dp)
    ) {
        val navController = rememberNavController()

        ProfileBar("Your library",libraryFilters) { navController.navigate("settings") }


        // Recently played section
        Text(
            "Recently played",
            color = Color.Gray,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
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
