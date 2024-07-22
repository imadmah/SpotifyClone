package com.example.spotifyclone.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
        LibraryItem("Liked Songs", "Playlist 58 songs",R.drawable.like_song_ic),
        LibraryItem("New Episodes", "Updated 2 days ago",R.drawable.new_episodes_ic),
        LibraryItem("Lolo Zouaï", "Artist",R.drawable.lolo_zouai_ic),
        LibraryItem("Lana Del Rey","Artist", R.drawable.lana_ic),
        LibraryItem("Marvin Gaye", "Artist",R.drawable.member1),
        LibraryItem("numbers", "Artist",R.drawable.members2),
        LibraryItem("Front Left", "Artist",R.drawable.front_left_ic),
        LibraryItem("After Burn", "Artist",R.drawable.afterburner),
        LibraryItem("Time Bomb", "Artist",R.drawable.time_bomb),

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

        Row(
        verticalAlignment = Alignment.CenterVertically,
          modifier =  Modifier.padding(vertical = 16.dp)

        ){
        Image(painter = painterResource(id = R.drawable.donnee_ic), contentDescription ="",Modifier.width(16.dp).height(12.dp) )
        Text(
            "Recently played",
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding( horizontal = 2.dp)
        )
            Spacer(Modifier.weight(1f))
            Image(painter = painterResource(id = R.drawable.to_grid_ic), contentDescription ="" ,Modifier.size(16.dp))

        }
        // Recently played section

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
            .padding(vertical = 8.dp)
            .clickable { }
        ,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = item.iconResId),
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )
        Column(){
        Text(
            item.name,
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 16.dp)
        )
            Text(
                item.type,
                color = Color.Gray,
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 16.dp, top = 4.dp)
            )
        }
    }
}
