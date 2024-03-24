package com.garrodroideveloper.muzzexercise.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.garrodroideveloper.muzzexercise.R
import com.garrodroideveloper.muzzexercise.shared.ui.components.MuzzArrowBack
import com.garrodroideveloper.muzzexercise.shared.ui.components.MuzzTitleText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavHost() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    var username by remember { mutableStateOf("") }

    val noBackButtonScreens =
        listOf(
            MainNavItems.Welcome,
        ).map { it.route }

    Scaffold(
        topBar = {
            Surface(shadowElevation = 5.dp) {
                TopAppBar(
                    colors =
                        topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.background,
                            titleContentColor = MaterialTheme.colorScheme.onBackground,
                        ),
                    title = {
                        if (navBackStackEntry?.destination?.route !in noBackButtonScreens) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Image(
                                    modifier = Modifier.width(24.dp).height(24.dp),
                                    painter =
                                        painterResource(
                                            id =
                                                if (username == "User") {
                                                    R.drawable.man_user_circle_icon
                                                } else {
                                                    R.drawable.woman_user_circle_icon
                                                },
                                        ),
                                    contentDescription = stringResource(id = R.string.profile_image),
                                )
                                MuzzTitleText(
                                    modifier =
                                        Modifier.padding(start = dimensionResource(id = R.dimen.single_margin)),
                                    value = username,
                                )
                            }
                        } else {
                            MuzzTitleText(value = stringResource(id = R.string.app_name))
                        }
                    },
                    navigationIcon = {
                        if (navBackStackEntry?.destination?.route !in noBackButtonScreens) {
                            // Show Back button
                            IconButton(onClick = { navController.navigateUp() }) {
                                Icon(
                                    imageVector = MuzzArrowBack(),
                                    tint = MaterialTheme.colorScheme.primary,
                                    contentDescription = stringResource(id = R.string.arrow_back),
                                )
                            }
                        }
                    },
                )
            }
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
            addMain(navController) { selectedUsername ->
                username = selectedUsername
            }
        }
    }
}
