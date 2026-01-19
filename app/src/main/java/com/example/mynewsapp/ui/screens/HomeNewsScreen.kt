package com.example.mynewsapp.ui.screens

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.mynewsapp.data.model.Article
import com.example.mynewsapp.vm.NewsVm

@Composable
fun HomeNewsScreen(
    vm: NewsVm,
    navController: NavHostController
) {

    val apiKey = "942ef02da3ae419bbe06ad60aa275f6b"

    LaunchedEffect(Unit) {
        vm.getNews(apiKey)
    }

    val newsList by vm.news.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            start = 16.dp,
            end = 16.dp,
            top = 20.dp,
            bottom = 16.dp
        ),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {

        item {
            Text(
                text = "Top Headlines",
                style = MaterialTheme.typography.titleLarge
            )
        }

        // 🔥 Featured headline
        newsList.firstOrNull()?.let { article ->
            item {
                FeaturedNewsCard(
                    article = article,
                    onClick = {
                        navController.navigate(
                            "detail/${Uri.encode(article.url)}"
                        )
                    }
                )
            }
        }

        // 📰 Remaining headlines
        items(newsList.drop(1)) { article ->
            HeadlineListItem(
                article = article,
                onClick = {
                    navController.navigate(
                        "detail/${Uri.encode(article.url)}"
                    )
                }
            )
        }
    }
}
@Composable
fun FeaturedNewsCard(
    article: Article,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {

        Column {

            if (!article.urlToImage.isNullOrEmpty()) {
                Image(
                    painter = rememberAsyncImagePainter(article.urlToImage),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            Column(modifier = Modifier.padding(14.dp)) {

                Text(
                    text = article.title,
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "${article.source.name} • 2h ago",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
@Composable
fun HeadlineListItem(
    article: Article,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {

        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            if (!article.urlToImage.isNullOrEmpty()) {
                Image(
                    painter = rememberAsyncImagePainter(article.urlToImage),
                    contentDescription = null,
                    modifier = Modifier
                        .size(72.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(12.dp))
            }

            Column(modifier = Modifier.weight(1f)) {

                Text(
                    text = article.title,
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 2
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "${article.source.name} • 2h ago",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
