package com.neluam.timeblockcounter.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.neluam.timeblockcounter.home.MenuScreen
import com.neluam.timeblockcounter.simplechronometer.SimpleChronometer

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreenId.Main.route) {
        composable(
            route = ScreenId.Main.route
        ){
            MenuScreen(
                goToSimpleChronometer = {
                    navController.navigate(route = ScreenId.SimpleChronometer.route)
                }
            )
        }
        composable(
            route = ScreenId.SimpleChronometer.route
        ){
            SimpleChronometer()
        }
    }
}