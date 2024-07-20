package com.example.spotifyclone.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spotifyclone.R

@Composable
fun ProfileBar(screen:String,items:List<String>,onclick : () -> Unit ) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier=Modifier.fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.lolo_zouai_ic),
            contentDescription = "Profile",
            modifier = Modifier.size(32.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text=screen,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.weight(1f))
        if(screen.isNotEmpty()){
        Icon(
            imageVector = Icons.Default.Add,
            tint = Color.White,
            contentDescription = "Add icon",
            modifier = Modifier.size(32.dp)
                .clickable {  }
        )}
        else {
            Icon(
                imageVector = Icons.Default.Notifications,
                tint = Color.White,
                contentDescription = "settings",
                modifier = Modifier.size(24.dp)
                    .clickable { }
            )
            Spacer(modifier = Modifier.width(16.dp))

                Icon(
                    painterResource(id = R.drawable.settings_ic) ,
                    tint = Color.White,
                    contentDescription = "settings",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {onclick() }
                )

        }

    }
    LazyRow {
        items(items) { filter ->
            OutlinedButton(
                onClick = { /* Handle button click */ },
                modifier = Modifier.padding(4.dp),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 2.dp)
            ) {
                Text(filter, color = Color.Gray, fontSize = 12.sp)
            }
        }
    }
}