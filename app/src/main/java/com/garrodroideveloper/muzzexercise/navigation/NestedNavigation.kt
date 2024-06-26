package com.garrodroideveloper.muzzexercise.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.garrodroideveloper.muzzexercise.message.MessageScreen
import com.garrodroideveloper.muzzexercise.welcome.WelcomeScreen

fun NavGraphBuilder.addMain(
    navHostController: NavHostController,
    onUsernameSelected: (String) -> Unit,
) {
    navigation(startDestination = MainNavItems.Welcome.route, route = MainNavItems.Start.route) {
        composable(MainNavItems.Welcome.route) {
            WelcomeScreen { username ->
                onUsernameSelected(username)
                navHostController.navigate(MainNavItems.Message.route.plus("/$username"))
            }
        }
        composable(
            route = MainNavItems.Message.route.plus("/{username}"),
            arguments =
                listOf(
                    navArgument("username") {
                        type = NavType.StringType
                    },
                ),
        ) {
            MessageScreen()
        }
    }
}
