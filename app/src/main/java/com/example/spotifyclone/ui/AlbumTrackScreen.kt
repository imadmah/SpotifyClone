package com.example.spotifyclone.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.spotifyclone.R
import com.example.spotifyclone.ui.theme.ScreenGrey
import com.example.spotifyclone.ui.theme.SpotifyGreen

    @Composable
    fun AlbumViewScreen(onclick: () -> Unit) {
        Column(
            modifier = Modifier
                .background(ScreenGrey)
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = "",tint = Color.White,
                modifier = Modifier.size(32.dp)
                    .clickable {onclick() }
                )
            Spacer(modifier = Modifier.size(16.dp))

            Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cover2),
                        contentDescription = "Album Cover",
                        modifier = Modifier.size(220.dp)
                    )
                }

                Spacer(modifier = Modifier.size(32.dp))
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {

                    Text(
                        text = "1 (Remastered)",
                        color = Color.White,
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier=Modifier.padding(vertical = 8.dp)

                    )
                    {
                    Image( painterResource(id =R.drawable.lana_ic ) , contentDescription ="" )
                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                        text = "The Beatles",
                        color = Color.Gray,
                        style = MaterialTheme.typography.labelMedium
                    )


                    }
                }

            Spacer(modifier = Modifier.height(16.dp))
            AlbumTrack("Love Me Do - Mono / Remastered","The Beatles")
            AlbumTrack("From Me to You - Mono / Remastered","The Beatles", isPlaying = true)
            AlbumTrack("She Loves You - Mono / Remastered","The Beatles")
            AlbumTrack("I Want To Hold Your Hand - Remastered 2015","The Beatles")
        }
    }

    @Composable
    fun AlbumTrack(trackName: String,trackSigners: String, isPlaying: Boolean = false) {
        Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            if (isPlaying) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Playing",
                    tint = Color.Green
                )
            }
            Text(
                text = trackName,
                color =  if (isPlaying) SpotifyGreen else Color.White,
                style = MaterialTheme.typography.bodyMedium,
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(imageVector = Icons.Default.MoreVert ,contentDescription ="Song Menu", tint = Color.White )
        }
            Text(
                text = trackSigners,
                color = Color.Gray,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(horizontal = 32.dp, vertical = 2.dp)
            )
        }


        Spacer(modifier = Modifier.size(16.dp))
    }

    @Composable
    fun AlbumControlScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF121212)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id= R.drawable.cover1),
                contentDescription = "Album Cover",
                modifier = Modifier.size(150.dp)
            )

            Text(
                text = "1 (Remastered)",
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = "The Beatles",
                color = Color.Gray,
                style = MaterialTheme.typography.labelSmall
            )
            Spacer(modifier = Modifier.height(64.dp))
            AlbumControlOption(icon = Icons.Default.Favorite, text = "Like")
            AlbumControlOption(icon = Icons.Default.Person, text = "View artist")
            AlbumControlOption(icon = Icons.Default.Share, text = "Share")
            AlbumControlOption(icon = Icons.Default.Favorite, text = "Like all songs")
            AlbumControlOption(icon = Icons.Default.Add, text = "Add to playlist")
            AlbumControlOption(icon = Icons.Default.Menu, text = "Add to queue")
            AlbumControlOption(icon = Icons.Default.Phone, text = "Go to radio")
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Close",
                color = Color.White,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }

    @Composable
    fun AlbumControlOption(icon: ImageVector, text: String) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = text,
                color = Color.White,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
