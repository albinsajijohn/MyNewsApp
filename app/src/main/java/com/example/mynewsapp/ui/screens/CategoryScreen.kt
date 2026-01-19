package com.example.mynewsapp.ui.screens

import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mynewsapp.vm.NewsVm

@Composable
fun CategoryScreen(
    vm: NewsVm,
    navController: NavHostController
) {

    val apiKey = "942ef02da3ae419bbe06ad60aa275f6b"

    val categories = listOf(
        "business",
        "sports",
        "technology",
        "health",
        "science",
        "entertainment"
    )

    val selectedCategory by vm.selectedCategory.collectAsState()
    val newsList by vm.news.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {

        // 🔹 Category Chips
        LazyRow(
            contentPadding = PaddingValues(12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(categories) { category ->
                FilterChip(
                    selected = selectedCategory == category,
                    onClick = {
                        vm.changeCategory(apiKey, category)
                    },
                    label = {
                        Text(category.replaceFirstChar { it.uppercase() })
                    }
                )
            }
        }

        // 🔹 News List
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(newsList) { article ->
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
}
