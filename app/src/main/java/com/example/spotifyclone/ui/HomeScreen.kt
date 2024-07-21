package com.example.spotifyclone.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spotifyclone.R
import com.example.spotifyclone.data.AlbumItem
import com.example.spotifyclone.ui.theme.ScreenGrey

@Composable
fun HomeScreen(onclick: () -> Unit, albumClick: () -> Unit) {

    val albumItems = listOf(
        AlbumItem("Tickets to my downfall", R.drawable.mgk),
        AlbumItem("Carnival", R.drawable.bryce_vine),
        AlbumItem("", R.drawable.cover3),
        AlbumItem("Run with me", R.drawable.cover2),
        AlbumItem("Alone here", R.drawable.cover4),
        AlbumItem("Never Cry", R.drawable.cover1),
        AlbumItem("Greta Van Fleet", R.drawable.anthem_of_the_peaceful_army)
    )
    val recentlyPlayed = listOf(
        AlbumItem("Carnival", R.drawable.time_bomb),
        AlbumItem("Dance Gavin Dance", R.drawable.member1),
        AlbumItem("My Ex’s Best Friend", R.drawable.afterburner),
        AlbumItem("Never Cry", R.drawable.cover1),
        AlbumItem("Tycho", R.drawable.tycho),
        AlbumItem("Run with me", R.drawable.bryce_vine)
    )
    val favouriteArtists = listOf(
        AlbumItem("Chon", R.drawable.chon),
        AlbumItem("Dance Gavin Dance", R.drawable.member1),
        AlbumItem("numbers", R.drawable.members2),
    )
    val yearReview = listOf(
        AlbumItem("Ed Sheeran, Big Sean, \nJuice WRLD, Post Malone", R.drawable.edition_pick_1),
        AlbumItem("Run with me", R.drawable.members2),
        AlbumItem("Chon", R.drawable.chon)
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
            .verticalScroll(rememberScrollState())
            .padding(8.dp)
    ) {
        ProfileBar("", libraryFilters, onclick)

        Text("Recently Played", fontWeight = FontWeight.Bold, color = Color.White, fontSize = 20.sp, modifier = Modifier.padding(16.dp))
        LazyRow {
            items(recentlyPlayed) { item ->
                AlbumItemRow(item, albumClick, rounded = false)
            }
        }

        Text("Your 2021 in review", fontWeight = FontWeight.Bold, color = Color.White, fontSize = 20.sp, modifier = Modifier.padding(16.dp))
        LazyRow {
            items(yearReview) { item ->
                AlbumItemRow(item, albumClick, rounded = false)
            }
        }

        Text("Editor's picks", fontWeight = FontWeight.Bold, color = Color.White, fontSize = 20.sp, modifier = Modifier.padding(16.dp))
        LazyRow {
            items(albumItems) { item ->
                AlbumItemRow(item, albumClick, rounded = false)
            }
        }

        Text("Your favourite artists", fontWeight = FontWeight.Bold, color = Color.White, fontSize = 24.sp, modifier = Modifier.padding(16.dp))
        LazyRow {
            items(favouriteArtists) { item ->
                AlbumItemRow(item, albumClick, rounded = true)
            }
        }
    }
}

@Composable
fun AlbumItemRow(item: AlbumItem, albumClick: () -> Unit, rounded: Boolean) {
    Column(
        modifier = Modifier
            .clickable { albumClick() }
            .padding(6.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = item.iconResId),
            contentDescription = null,
            modifier = Modifier
                .size(145.dp)
                .let {
                    if (rounded) {
                        it.clip(CircleShape)
                    } else {
                        it
                    }
                }
        )
        Text(item.name, color = Color.White, fontSize = 12.sp, modifier = Modifier.padding(top = 2.dp))
    }
}
