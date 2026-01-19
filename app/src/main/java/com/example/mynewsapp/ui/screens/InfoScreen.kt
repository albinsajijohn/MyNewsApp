package com.example.mynewsapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mynewsapp.R

@Composable
fun InfoScreen() {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        item {
            Image(
                painter = painterResource(id = R.drawable.developer),
                contentDescription = "App Logo",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }

        item {
            Text(
                text = "My News App",
                style = MaterialTheme.typography.titleLarge
            )
        }

        item {
            Text(
                text = "Version 1.0",
                style = MaterialTheme.typography.bodySmall
            )
        }

        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("About the App", style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "Our News App provides the latest top headlines across various categories like Business, Sports, Technology, Health and more. It is built using modern Android technologies including Jetpack Compose, MVVM, Retrofit and Hilt."
                    )
                }
            }
        }

        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Developed By",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {

                        // 🔹 Developer 1
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {

                            Image(
                                painter = painterResource(id = R.drawable.albz),
                                contentDescription = "Developer Photo",
                                modifier = Modifier
                                    .size(90.dp)
                                    .clip(CircleShape),
                                contentScale = ContentScale.Crop
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text("Albin Saji", style = MaterialTheme.typography.titleSmall)
                            Text("Android Developer", style = MaterialTheme.typography.bodySmall)
                        }

                        // 🔹 Developer 2
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {

                            Image(
                                painter = painterResource(id = R.drawable.gopz),
                                contentDescription = "Developer Photo",
                                modifier = Modifier
                                    .size(90.dp)
                                    .clip(CircleShape),
                                contentScale = ContentScale.Crop
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text("Gopika M Panicker", style = MaterialTheme.typography.titleSmall)
                            Text("Android Developer", style = MaterialTheme.typography.bodySmall)
                        }
                    }
                }
            }
        }

        item {
            Text(
                text = "© 2026 My News App",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
