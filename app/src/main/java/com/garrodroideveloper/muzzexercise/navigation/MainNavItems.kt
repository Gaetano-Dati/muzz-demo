package com.garrodroideveloper.muzzexercise.navigation

private enum class MainNavScreen {
    START,
    WELCOME,
    MAIN,
}

sealed class MainNavItems(
    val route: String,
) {
    object Start : MainNavItems(MainNavScreen.START.name)

    object Welcome : MainNavItems(MainNavScreen.WELCOME.name)

    object Main : MainNavItems(MainNavScreen.MAIN.name)
}
