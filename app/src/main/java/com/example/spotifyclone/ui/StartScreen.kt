package com.example.spotifyclone.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spotifyclone.R
import com.example.spotifyclone.ui.theme.ScreenGrey
import com.example.spotifyclone.ui.theme.SpotifyGreen

@Composable
fun StartScreen(
    onSignUpClick: () -> Unit,
    onGoogleClick: () -> Unit,
    onFacebookClick: () -> Unit,
    onAppleClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ScreenGrey)
            .padding(horizontal = 32.dp, vertical = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.spotify_primary_logo), contentDescription = null, modifier = Modifier.size(60.dp))
        Spacer(modifier = Modifier.height(32.dp))
        Text("Millions of Songs.", color = Color.White, fontSize = 24.sp,fontWeight = FontWeight.Bold)
        Text("Free on Spotify.", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(32.dp))
      Button(
            onClick = onSignUpClick,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = SpotifyGreen, contentColor = Color.Black) ,
        ) {
            Spacer(modifier = Modifier.width(8.dp))
            Text("Sign up free", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        }
        Spacer(modifier = Modifier.height(4.dp))

        OutlinedButton(
            onClick = onGoogleClick,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(32.dp))
                Text("Continue with Google",fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
        }


        Spacer(modifier = Modifier.height(4.dp))

        OutlinedButton(
            onClick = onFacebookClick,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
        ) {
            Row(horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()

            ){
                Icon(
                    painter = painterResource(id = R.drawable.fb_logo),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(26.dp)
                )
                Spacer(modifier = Modifier.width(32.dp))
                Text("Continue with Facebook",fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.height(16.dp))

        }

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedButton(

            onClick = onAppleClick,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
        ) {
            Row(horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
            ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_apple),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.size(26.dp)
            )
            Spacer(modifier = Modifier.width(32.dp))
            Text("Continue with Apple",fontWeight = FontWeight.Bold, fontSize = 16.sp)
        }
        }


        TextButton(onClick = onLoginClick) {
            Text("Log in", color = Color.White,fontWeight = FontWeight.Bold)
        }
    }
}
