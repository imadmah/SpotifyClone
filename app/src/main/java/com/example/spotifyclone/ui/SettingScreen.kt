package com.example.spotifyclone.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spotifyclone.R
import com.example.spotifyclone.ui.theme.ScreenGrey
import okio.Options

@Preview(showBackground = true)
    @Composable
    fun SettingsScreen() {
        val options = listOf(
            "Data Saver",
            "Languages",
            "Playback",
            "Explicit Content",
            "Devices",
            "Car",
            "Social",
            "Voice Assistant & Apps",
            "Audio Quality",
            "Storage"
        )
        Column(
            modifier = Modifier
                .background(ScreenGrey)
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cover3) ,
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(shape = MaterialTheme.shapes.large)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = "Imadeddine Mahouni",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        text = "View Profile",
                        color = Color.Gray,
                        style = MaterialTheme.typography.labelSmall
                    )

                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Next",
                    tint = Color.Gray
                )
            }
            Spacer(modifier = Modifier.size(16.dp))

            LazyColumn {
           items(options){ item ->
               SettingsOption(item)
           }




            }
        }
    }

    @Composable
    fun SettingsOption(option: String) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {  }
                .padding(horizontal = 16.dp, vertical = 16.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = option,
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Next",
                tint = Color.Gray
            )
        }
    }


