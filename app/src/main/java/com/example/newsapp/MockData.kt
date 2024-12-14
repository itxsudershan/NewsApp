package com.example.newsapp

import android.os.Build
import android.util.Log
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

object MockData {
    private val topNewsList = listOf<NewsData>(
        NewsData(
            1,
            image = R.drawable.person_02,
            author = "Mangi",
            title = "Picker is the most powerful men. This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.\\n\" +\n" +
                    "                    \"It also contains some basic inner content, such as this text.",
            description = "Picker is the most powerful men",
            publishedAt = "2023-11-04T01:55:30"
        ),
        NewsData(
            2,
            image = R.drawable.person_02,
            author = "Mangi",
            title = "Picker is the most powerful men. This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.\\n\" +\n" +
                    "                    \"It also contains some basic inner content, such as this text.",
            description = "Picker is the most powerful men",
            publishedAt = "2023-11-04T01:55:30"
        ),
        NewsData(
            3,
            image = R.drawable.person_02,
            author = "Mangi",
            title = "Picker is the most powerful men. This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.\\n\" +\n" +
                    "                    \"It also contains some basic inner content, such as this text.",
            description = "Picker is the most powerful men",
            publishedAt = "2023-11-04T01:55:30"
        ),
        NewsData(
            4,
            image = R.drawable.person_02,
            author = "Mangi",
            title = "Picker is the most powerful men. This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.\\n\" +\n" +
                    "                    \"It also contains some basic inner content, such as this text.",
            description = "Picker is the most powerful men",
            publishedAt = "2023-11-04T01:55:30"
        ),NewsData(
            5,
            image = R.drawable.person_02,
            author = "Mangi",
            title = "Picker is the most powerful men. This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.\\n\" +\n" +
                    "                    \"It also contains some basic inner content, such as this text.",
            description = "Picker is the most powerful men",
            publishedAt = "2023-11-04T01:55:30"
        ),NewsData(
            6,
            image = R.drawable.person_02,
            author = "Mangi",
            title = "Picker is the most powerful men. This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.\\n\" +\n" +
                    "                    \"It also contains some basic inner content, such as this text.",
            description = "Picker is the most powerful men",
            publishedAt = "2023-11-04T01:55:30"
        ),
        NewsData(
            7,
            image = R.drawable.person_02,
            author = "Mangi",
            title = "Picker is the most powerful men. This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.\\n\" +\n" +
                    "                    \"It also contains some basic inner content, such as this text.",
            description = "Picker is the most powerful men",
            publishedAt = "2023-11-04T01:55:30"
        ),
        NewsData(
            8,
            image = R.drawable.person_02,
            author = "Mangi",
            title = "Picker is the most powerful men. This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.\\n\" +\n" +
                    "                    \"It also contains some basic inner content, such as this text.",
            description = "Picker is the most powerful men. This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.\n" +
                    "It also contains some basic inner content, such as this text. You have pressed the floating action button  times.",
            publishedAt = "2023-11-04T01:55:30"
        ),
    )
    fun getNews(newsId: Int?):NewsData{
        return topNewsList.first{it.id == newsId}
    }
    fun Date.getTimeAgo(): String {
        val calendar = Calendar.getInstance()
        calendar.time = this
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val currentCalendar = Calendar.getInstance()

        val currentYear = currentCalendar.get(Calendar.YEAR)
        val currentMonth = currentCalendar.get(Calendar.MONTH)
        val currentDay = currentCalendar.get(Calendar.DAY_OF_MONTH)
        val currentHour = currentCalendar.get(Calendar.HOUR_OF_DAY)
        val currentMinute = currentCalendar.get(Calendar.MINUTE)

        return if(year<currentYear){
            val interval = currentYear - year
            if(interval==1) "$interval year ago" else "$interval yaers ago"
        }else if (month < currentMonth){
            val interval = currentMonth - month
            if (interval == 1) "$interval month ago" else "$interval months ago"
        }else if (day < currentDay){
            val interval = currentDay - day
            if (interval == 1) "$interval day ago" else "$interval days ago"
        }else if (hour < currentHour){
            val interval = currentHour - hour
            if (interval == 1) "$interval hour ago" else "$interval hours ago"
        }else if (minute < currentMinute){
            val interval = currentMinute - minute
            if (interval == 1) "$interval minute ago" else "$interval minutes ago"
        }else
        {
            "a moment ago"
        }
    }
    fun stringToDate(publishedAt: String): Date {
        val date =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH).parse(publishedAt)
            }else {
                SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH).parse(publishedAt)
            }
        Log.d("publishedAt", "$date")
        return date
    }
}