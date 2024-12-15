package com.example.newsapp.ui.screens

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newsapp.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AboutUsScreen()
        }
    }
}

@Composable
fun AboutUsScreen() {
    // Box to arrange all elements
    Box(modifier = Modifier.fillMaxSize()) {

        // Column for Title and Description
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            // Title
            Text(
                text = "About Us",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Description
            Text(
                text = "We are a team of passionate individuals dedicated to providing exceptional services and solutions. Our mission is to make a difference and bring value to our customers.",
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }

        // Social Media Icons at the bottom
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            SocialMediaIcon(icon = R.drawable.facebook)
            Spacer(modifier = Modifier.width(16.dp))
            SocialMediaIcon(icon = R.drawable.twitter)
            Spacer(modifier = Modifier.width(16.dp))
            SocialMediaIcon(icon = R.drawable.instagram)
        }
    }
}

@Composable
fun SocialMediaIcon(icon: Int) {
    val socialIcon: Painter = painterResource(id = icon)
    Box(
//        onClick = { /* Handle click action */ },
        modifier = Modifier.size(48.dp),
//        shape = CircleShape,
//        colors = ButtonDefaults.buttonColors(containerColor = Color.)
    ) {
        Image(
            painter = socialIcon,
            contentDescription = "Social Media Icon",
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AboutUsScreenPreview() {
    AboutUsScreen()
}
