package com.example.newsapp.ui.screens

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.MainActivity
import com.example.newsapp.ui.NewsApp
import kotlinx.coroutines.delay
import com.example.newsapp.R

@Composable
fun NavigationApp() {
    val navController = rememberNavController()

    // Define the navigation graph
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(navController = navController)
        }
        composable("topNews") {
            NewsApp()
        }
    }
}

@Composable
fun SplashScreen(navController: NavHostController) {
    // Box allows stacking elements on top of each other
    Box(modifier = Modifier.fillMaxSize()) {

        // Background image
        val backgroundImage: Painter = painterResource(id = R.drawable.back) // Replace with your image
        Image(
            painter = backgroundImage,
            contentDescription = "Splash Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Centered Logo
        val logo: Painter = painterResource(id = R.drawable.newslogo) // Replace with your logo
        Image(
            painter = logo,
            contentDescription = "Logo",
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Center)
                .clip(shape = CircleShape)
                .size(220.dp)
        )
    }

    // Navigate to the main screen after 2 seconds
    LaunchedEffect(true) {
        delay(2000)
        navController.navigate("topNews") {
            popUpTo("splash") { inclusive = true } // Pop the splash screen off the stack
        }
    }
}