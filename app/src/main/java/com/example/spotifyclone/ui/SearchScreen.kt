package com.example.spotifyclone.ui

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.spotifyclone.R

@Preview
@Composable
fun SearchScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding( 16.dp),

        ) {
        Text(
            text = "Search",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.weight(1f))
            Image(painter = painterResource(id = R.drawable.camera_ic), contentDescription ="",Modifier.width(25.dp).height(22.dp) )
        }


        TextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "Artists, songs, or podcasts", color = Color.Gray)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search Icon",
                    tint = Color.Gray
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .background(Color.White, shape = RoundedCornerShape(8.dp))
        )

        Column(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
        ) {
            Text(
                text = "Your top genres",
                fontWeight = FontWeight.SemiBold,
                color = Color.White,

                )
            Spacer(modifier = Modifier.size(8.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
            ) {
                items(listOf(
                    "Pop" to Color(0xFF9854B2),
                    "Indie" to Color(0xFF678026)
                )) { (genre, color) ->
                    GenreCard(
                        text = genre,
                        backgroundColor = color,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            Text(
                text = "Popular podcast categories",
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 16.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
            ) {
                items(listOf(
                    "News & Politics" to Color(0xFF3371E4),
                    "Comedy" to Color(0xFFCF4321),
                )) { (category, color) ->
                    GenreCard(
                        text = category,
                        backgroundColor = color,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            Text(
                text = "Browse all",
                color = Color.White,
                modifier = Modifier.padding(top = 16.dp),
                        fontWeight = FontWeight.SemiBold,

                )
            Spacer(modifier = Modifier.size(8.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
            ) {
                items(listOf(
                    "2023 Wrapped" to Color(0xFFABBB6D),
                    "Podcasts" to Color(0xFF223160),
                    "Charts" to Color(0xFF75A768),
                    "Made for you" to Color(0xFF8768A7)
                )) { (item, color) ->
                    GenreCard(
                        text = item,
                        backgroundColor = color,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }

    }
}

@Composable
fun GenreCard(text: String, backgroundColor: Color, modifier: Modifier) {
    Card(
        colors = CardDefaults.cardColors().copy(containerColor = backgroundColor),
        modifier = modifier
            .height(110.dp)
            .width(190.dp)
            .padding(8.dp)

    ) {
        Box(
            modifier = modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomEnd

        ) {
            Text(
                text = text,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(8.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.mini_album_card),
                contentDescription = "",
                modifier = Modifier
                    .size(72.dp)
                    .align(Alignment.BottomEnd)
            )
        }
    }
}
