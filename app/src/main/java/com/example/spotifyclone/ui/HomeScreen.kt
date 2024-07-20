package com.example.spotifyclone.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spotifyclone.R
import com.example.spotifyclone.data.AlbumItem
import com.example.spotifyclone.ui.theme.ScreenGrey
import com.example.spotifyclone.ui.theme.ScreenGrey2


@Composable
fun HomeScreen(onclick : () -> Unit,albumClick : () -> Unit ) {

    val albumItems = listOf (
        AlbumItem("",R.drawable.mgk),
        AlbumItem("",R.drawable.bryce_vine),
        AlbumItem("",R.drawable.afterburner),
        AlbumItem("",R.drawable.cover3),
        AlbumItem("",R.drawable.cover2),
        AlbumItem("",R.drawable.cover5),
        AlbumItem("",R.drawable.cover4),
        AlbumItem("",R.drawable.cover1),


    )
    val recentlyPlayed = listOf(
        AlbumItem("",R.drawable.bryce_vine),
        AlbumItem("",R.drawable.afterburner),
        AlbumItem("",R.drawable.cover1),
        AlbumItem("Lana Del Rey",R.drawable.lana_ic),
        AlbumItem("Marvin Gaye",R.drawable.marvin_gaye_ic),
        AlbumItem("",R.drawable.cover2)
    )
    val favouriteArtists = listOf(
        AlbumItem("front_left",R.drawable.front_left_ic),
        AlbumItem("Lana Del Rey",R.drawable.lana_ic),
        AlbumItem("Marvin Gaye",R.drawable.marvin_gaye_ic),
        AlbumItem("",R.drawable.cover2)
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
        ProfileBar("",libraryFilters, onclick )


        Text("Recently Played", fontWeight = FontWeight.Bold,color = Color.White, fontSize = 20.sp, modifier = Modifier.padding(16.dp))

        // Recently played section
        LazyRow {
            items(recentlyPlayed ){ item ->
                AlbumItemRow(item,albumClick)

            }
        }

        // Your 2021 in review section
        Text("Your 2021 in review", fontWeight = FontWeight.Bold,color = Color.White, fontSize = 20.sp, modifier = Modifier.padding(16.dp))
        Row(modifier = Modifier.padding(8.dp)) {
            Image(painter = painterResource(id = R.drawable.edition_pick_1), contentDescription = null, modifier = Modifier.size(140.dp))
            Spacer(modifier = Modifier.size(16.dp))
            Image(painter = painterResource(id = R.drawable.afterburner), contentDescription = null, modifier = Modifier.size(140.dp))
        }

        // Editor's picks section
        Text("Editor's picks", fontWeight = FontWeight.Bold, color = Color.White, fontSize = 20.sp, modifier = Modifier.padding(16.dp))
        LazyRow {
            items(albumItems ){ item ->
            AlbumItemRow(item,albumClick)

            }
        }

        Text("Your favourite artists", fontWeight = FontWeight.Bold, color = Color.White, fontSize = 24.sp, modifier = Modifier.padding(16.dp))
        LazyRow {
            items(favouriteArtists ){ item ->
                AlbumItemRow(item,albumClick)

            }
        }

    }
}

@Composable
fun AlbumItemRow(item: AlbumItem,albumClick : () -> Unit) {
    Column(
        modifier = Modifier
            .clickable { albumClick() }
            .padding(8.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painterResource(id = item.iconResId), contentDescription = null, modifier = Modifier.size(145.dp))
        Text(item.name, color = Color.White, fontSize = 12.sp, modifier = Modifier.padding(top = 4.dp))
    }
}
