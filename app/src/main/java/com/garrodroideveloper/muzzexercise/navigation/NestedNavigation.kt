package com.garrodroideveloper.muzzexercise.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.garrodroideveloper.muzzexercise.home.MainScreen
import com.garrodroideveloper.muzzexercise.welcome.WelcomeScreen

fun NavGraphBuilder.addMain(navController: NavHostController) {
    navigation(startDestination = MainNavItems.Welcome.route, route = MainNavItems.Start.route) {
        composable(MainNavItems.Welcome.route) {
            WelcomeScreen()
        }
        composable(MainNavItems.Main.route) {
            MainScreen()
        }
    }
}
