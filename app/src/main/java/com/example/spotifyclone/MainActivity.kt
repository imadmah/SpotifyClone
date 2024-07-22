package com.example.spotifyclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spotifyclone.ui.theme.SpotifyCloneTheme
import com.example.spotifyclone.ui.theme.ScreenGrey
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.spotifyclone.ui.AlbumViewScreen
import com.example.spotifyclone.ui.HomeScreen
import com.example.spotifyclone.ui.LibraryScreen
import com.example.spotifyclone.ui.SearchScreen
import com.example.spotifyclone.ui.SettingsScreen
import com.example.spotifyclone.ui.StartScreen



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpotifyCloneTheme {
                val navController = rememberNavController()
                val currentBackStackEntry = navController.currentBackStackEntryAsState()
                val currentDestination = currentBackStackEntry.value?.destination?.route
                Scaffold(
                    bottomBar = { if(currentDestination!="start") NavBar(navController) },


                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "start",
                        modifier = Modifier
                            .padding(innerPadding)

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
                        composable("search"){
                            SearchScreen()
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
            val currentBackStackEntry = navController.currentBackStackEntryAsState()
            val currentDestination = currentBackStackEntry.value?.destination?.route
            Scaffold(
                bottomBar = {if(currentDestination!="start") { NavBar(navController)} }
            ) { innerPadding ->
                NavHost(
                    navController = navController,
                    startDestination = "album",
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
                    composable("search"){
                        SearchScreen()
                    }


                }
            }
        }
    }




    @Composable
    fun NavBar(navController: NavController) {
        val currentBackStackEntry = navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStackEntry.value?.destination?.route

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(ScreenGrey)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NavBarItem(
                imageRessource = if (currentDestination != "home") R.drawable.home_ic else R.drawable.home_ic_selected,
                text = "Home",
                onClick = { navController.navigate("home") },
                modifier = Modifier.weight(1f) // Example: Set weight dynamically
            )
            NavBarItem(
                imageRessource = if (currentDestination != "search") R.drawable.search_ic else R.drawable.search_ic_selected,
                text = "Search",
                onClick = { navController.navigate("search") },
                modifier = Modifier.weight(1f) // Example: Set weight dynamically
            )
            NavBarItem(
                imageRessource = if (currentDestination != "library") R.drawable.library_ic else R.drawable.library_ic_selected,
                text = "Library",
                onClick = { navController.navigate("library") },
                modifier = Modifier.weight(1f) // Example: Set weight dynamically
            )
        }
    }

@Composable
fun NavBarItem(@DrawableRes imageRessource: Int, text: String, onClick: () -> Unit, modifier: Modifier ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .clickable(onClick = onClick)

        ) {
            Image(painter = painterResource(id = imageRessource),
                contentDescription = "",   modifier = Modifier.size(22.dp))
            Text(
                text = text,
                fontSize = 8.sp,
                color = Color.LightGray,
                style = MaterialTheme.typography.titleMedium
            )
        }

}
}