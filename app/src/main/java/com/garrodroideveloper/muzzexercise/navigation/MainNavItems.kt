package com.garrodroideveloper.muzzexercise.navigation

private enum class MainNavScreen {
    START,
    WELCOME,
    MESSAGE,
}

sealed class MainNavItems(
    val route: String,
) {
    object Start : MainNavItems(MainNavScreen.START.name)

    object Welcome : MainNavItems(MainNavScreen.WELCOME.name)

    object Message : MainNavItems(MainNavScreen.MESSAGE.name)
}
