package com.example.newsapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomMenuScreen(val route: String,  val icon: ImageVector, val title: String) {
    object TopNews : BottomMenuScreen("topNews", icon = Icons.Outlined.Home, "TopNews")
    object Categories : BottomMenuScreen("categories", icon = Icons.Outlined.Home, "Categories")
    object Sources : BottomMenuScreen("about", icon = Icons.Outlined.Home, "About Us")
}