package com.example.newsapp.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.newsapp.BottomMenuScreen
import com.example.newsapp.MockData
import com.example.newsapp.components.BottomMenu
import com.example.newsapp.models.TopNewsArticles
import com.example.newsapp.network.NewsManager
import com.example.newsapp.ui.screens.AboutUsScreen
import com.example.newsapp.ui.screens.Categories
import com.example.newsapp.ui.screens.DetailsScreen
import com.example.newsapp.ui.screens.TopNews

@Composable
fun NewsApp() {
    val scrollState = rememberScrollState()
    val navController = rememberNavController()
    MainScreen(navController, scrollState)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController, scrollState: ScrollState) {
    Scaffold(
        bottomBar = {
            BottomMenu(navController)
        }
    ) { innerPadding ->
        Box {
            Navigation(navController, scrollState, paddingValues = innerPadding)
        }
    }
}

@Composable
fun Navigation(
    navController: NavHostController,
    scrollState: ScrollState,
    newsManager: NewsManager = NewsManager(),
    paddingValues: PaddingValues
) {
    val articles = newsManager.newsResponse.value.articles
    Log.d("news", "$articles")
    articles?.let {
    NavHost(
        navController = navController,
        startDestination = BottomMenuScreen.TopNews.route,
        modifier = Modifier.padding(paddingValues)
    ) {

            bottomNavigation(navController = navController, articles, newsManager)

            composable("Details/{index}",
                arguments = listOf(
                    navArgument("index") {
                        type = NavType.IntType
                    }
                )) { navBackStackEntry ->
                val index = navBackStackEntry.arguments?.getInt("index")
                index?.let {
                    val articles = articles[index]
                    DetailsScreen(articles, scrollState = scrollState, navController)
                }
            }
        }
    }
}

fun NavGraphBuilder.bottomNavigation(
    navController: NavController,
    articles: List<TopNewsArticles>,
    newsManager: NewsManager
) {
    composable(BottomMenuScreen.TopNews.route) {
        TopNews(navController = navController, articles)
    }
    composable(BottomMenuScreen.Categories.route) {
        newsManager.getArticlesByCategory("business")
        newsManager.onSelectedcategoryChanged("business")
        Categories(newsManager = newsManager, onFetchCategory = {
            newsManager.onSelectedcategoryChanged(it)
            newsManager.getArticlesByCategory(it)
        })
    }
    composable(BottomMenuScreen.Sources.route)
    {
        AboutUsScreen()
    }
}