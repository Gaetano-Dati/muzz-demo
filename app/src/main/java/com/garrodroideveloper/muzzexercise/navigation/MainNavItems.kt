package com.garrodroideveloper.muzzexercise.navigation

private enum class MainNavScreen {
    WELCOME,
    MAIN,
}

sealed class MainNavItems(
    val route: String,
) {
    object Welcome : MainNavItems(MainNavScreen.WELCOME.name)

    object Main : MainNavItems(MainNavScreen.MAIN.name)
}
