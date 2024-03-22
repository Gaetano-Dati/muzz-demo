package com.garrodroideveloper.muzzexercise.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation

fun NavGraphBuilder.addMain(navController: NavHostController) {
    navigation(startDestination = MainNavItems.Welcome.route, route = MainNavItems.Main.route) {
        composable(MainNavItems.Welcome.route) {
            // TODO place welcome screen
        }
        composable(MainNavItems.Main.route) {
            // TODO place Main composable
        }
    }
}
