package com.example.mynewsapp.ui.navigation


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    object Home : BottomNavItem(
        route = "home",
        label = "Home",
        icon = Icons.Filled.Home
    )

    object Category : BottomNavItem(
        route = "category",
        label = "Category",
        icon = Icons.Filled.List
    )

    object Info : BottomNavItem(
        route = "info",
        label = "Info",
        icon = Icons.Filled.Info
    )
}
