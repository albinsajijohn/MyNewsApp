package com.example.mynewsapp.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.*
import com.example.mynewsapp.ui.components.NewsBottomNavigation
import com.example.mynewsapp.vm.NewsVm

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(vm: NewsVm) {

    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val showBackButton = currentRoute != "home"

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = when {
                            currentRoute?.startsWith("detail") == true -> "Article"
                            currentRoute == "category" -> "Categories"
                            currentRoute == "info" -> "Info"
                            else -> "News App"
                        },
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                navigationIcon = {
                    if (showBackButton) {
                        IconButton(onClick = {
                            navController.popBackStack()
                        }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.White
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF2F63C6),
                    titleContentColor = Color.White
                )
            )
        },
        containerColor = Color(0xFFF6F7FB),
        bottomBar = {
            if (!currentRoute.orEmpty().startsWith("detail")) {
                NewsBottomNavigation(navController = navController)
            }
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(paddingValues)
        ) {

            composable("home") {
                HomeNewsScreen(vm, navController)
            }

            composable("category") {
                CategoryScreen(vm, navController)
            }

            composable("info") {
                InfoScreen()
            }

            composable("detail/{url}") { backStackEntry ->
                val url = backStackEntry.arguments?.getString("url")
                DetailScreen(vm = vm, url = url)
            }
        }
    }
}
