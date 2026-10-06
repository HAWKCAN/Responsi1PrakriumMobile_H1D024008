package com.pemmob.responsi1_fariz.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pemmob.responsi1_fariz.ui.detail.DetailScreen
import com.pemmob.responsi1_fariz.ui.home.HomeScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(onPokemonClick = { name -> navController.navigate("detail/$name") })
        }
        composable(
            route = "detail/{name}",
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name").orEmpty()
            DetailScreen(name = name, onBack = { navController.popBackStack() })
        }
    }
}
