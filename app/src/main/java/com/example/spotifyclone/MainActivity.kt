package com.example.spotifyclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spotifyclone.ui.theme.SpotifyCloneTheme
import com.example.spotifyclone.ui.theme.ScreenGrey
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.spotifyclone.ui.AlbumViewScreen
import com.example.spotifyclone.ui.HomeScreen
import com.example.spotifyclone.ui.LibraryScreen
import com.example.spotifyclone.ui.SettingsScreen
import com.example.spotifyclone.ui.StartScreen



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpotifyCloneTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = { NavBar(navController) }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "start",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("start") {
                            StartScreen(
                                onSignUpClick = { /* Handle Sign Up click */ },
                                onGoogleClick = { /* Handle Google click */ },
                                onFacebookClick = { /* Handle Facebook click */ },
                                onAppleClick = { /* Handle Apple click */ },
                                onLoginClick = { navController.navigate("home") }
                            )
                        }
                        composable("home") {
                            HomeScreen({ navController.navigate("settings") },{ navController.navigate("album") })
                        }
                        composable("library") {
                            LibraryScreen()
                        }
                        composable("settings"){
                            SettingsScreen()
                        }
                        composable("album"){
                            AlbumViewScreen{ navController.navigate("home") }
                        }
                    }
                }
            }
        }
    }



    @Preview(showBackground = true)
    @Composable
    fun Preview() {
        SpotifyCloneTheme {
            val navController = rememberNavController()
            Scaffold(
                bottomBar = { NavBar(navController) }
            ) { innerPadding ->
                NavHost(
                    navController = navController,
                    startDestination = "home",
                    modifier = Modifier.padding(innerPadding)
                ) {
                    composable("home") {
                        HomeScreen({ navController.navigate("settings") },{ navController.navigate("album") })
                    }
                    composable("library") {
                        LibraryScreen()
                    }
                    composable("settings"){
                        SettingsScreen()
                    }
                    composable("album"){
                        AlbumViewScreen{ navController.navigate("home") }
                    }
                }
            }
        }
    }




    @Composable
    fun NavBar(navController: NavController) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(ScreenGrey),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NavBarItem(
                icon = Icons.Default.Home,
                text = "Home",
                onClick = { navController.navigate("home") },
                modifier = Modifier.weight(1f) // Example: Set weight dynamically
            )
            NavBarItem(
                icon = Icons.Default.Search,
                text = "Search",
                onClick = { navController.navigate("search") },
                modifier = Modifier.weight(1f) // Example: Set weight dynamically
            )
            NavBarItem(
                icon = Icons.Default.Menu,
                text = "Library",
                onClick = { navController.navigate("library") },
                modifier = Modifier.weight(1f) // Example: Set weight dynamically
            )
        }
    }

@Composable
fun NavBarItem(icon: ImageVector, text: String, onClick: () -> Unit,modifier: Modifier ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .clickable(onClick = onClick)
                .padding(vertical = 8.dp)

        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.LightGray,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = text,
                fontSize = 8.sp,
                color = Color.LightGray,
                style = MaterialTheme.typography.titleMedium
            )
        }

}
}