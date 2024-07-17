@file:OptIn(ExperimentalMaterial3Api::class)

package dev.jgabriel.navigation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dev.jgabriel.navigation.routes.Home
import dev.jgabriel.navigation.routes.homeScreen
import dev.jgabriel.navigation.routes.profileScreen
import dev.jgabriel.navigation.routes.stringListScreen
import dev.jgabriel.navigation.ui.theme.ComposeNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeNavigationTheme {
                val navController = rememberNavController()
                var showBackButtonOnToolbar by remember {
                    mutableStateOf(false)
                }
                navController.addOnDestinationChangedListener(
                    listener = { controller, destination, arguments ->
                        Log.d("teste", destination.route.orEmpty())
                        showBackButtonOnToolbar =
                            destination.route != Home.serializer().descriptor.serialName
                    },
                )
                Column {
                    TopAppBar(
                        title = { Text(text = "Toolbar") },
                        navigationIcon = {
                            if (showBackButtonOnToolbar) {
                                IconButton(onClick = { navController.navigateUp() }) {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                        contentDescription = "Localized description",
                                    )
                                }
                            }
                        },
                    )
                    NavHost(navController = navController, startDestination = Home) {
                        homeScreen(navController)
                        profileScreen(navController)
                        stringListScreen(navController)
                    }
                }
            }
        }
    }
}
