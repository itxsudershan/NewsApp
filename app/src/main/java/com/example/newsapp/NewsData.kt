package com.example.newsapp

data class NewsData(
    val id: Int,
    val image: Int = R.drawable.person_02,
    val author: String,
    val title: String,
    val description: String,
    val publishedAt: String
)
