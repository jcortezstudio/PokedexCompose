package com.jcortezstudio.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.jcortezstudio.pokedex.ui.PokedexApp
import com.jcortezstudio.pokedex.ui.detail.DetailScreen
import com.jcortezstudio.pokedex.ui.home.HomeScreen
import com.jcortezstudio.pokedex.ui.navigation.PokeNav
import com.jcortezstudio.pokedex.ui.theme.PokedexTheme
import com.jcortezstudio.pokedex.ui.theme.White
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                NavigationHost()
            }
        }
    }
}

@Composable
fun NavigationHost() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = MaterialTheme.colors.isLight
    val navController = rememberNavController()
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = White,
            darkIcons = useDarkIcons
        )
    }
    PokedexApp {
        NavHost(
            navController = navController,
            startDestination = PokeNav.Home.route
        ) {
            composable(route = PokeNav.Home.route) {
                HomeScreen(navController = navController)
            }
            composable(
                route = PokeNav.Detail.route,
                arguments = listOf(navArgument("pokemonName"){ type = NavType.StringType})
            ) { backStackEntry ->
                DetailScreen(navController = navController)
            }
        }
    }
}
