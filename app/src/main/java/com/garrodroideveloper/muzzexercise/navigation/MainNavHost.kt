package com.garrodroideveloper.muzzexercise.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.garrodroideveloper.muzzexercise.R
import com.garrodroideveloper.muzzexercise.shared.ui.components.MuzzMediumText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavHost() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val context = LocalContext.current

    val noBackButtonScreens =
        listOf(
            MainNavItems.Welcome,
        ).map { it.route }

    val noBottomBarRoutes =
        listOf(
            MainNavItems.Welcome,
        ).map { it.route }

    Scaffold(
        topBar = {
            TopAppBar(
                colors =
                    topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                title = {
                    MuzzMediumText(value = "Title")
                },
                navigationIcon = {
                    if (navBackStackEntry?.destination?.route !in noBackButtonScreens) {
                        // Show Back button
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                Icons.Filled.ArrowBack,
                                stringResource(id = R.string.arrow_back),
                            )
                        }
                    }
                },
            )
        },
    ) {
        NavHost(
            modifier =
                Modifier
                    .padding(it)
                    .fillMaxSize(),
            navController = navController,
            startDestination = MainNavItems.Start.route,
        ) {
            addMain(navController = navController)
        }
    }
}
