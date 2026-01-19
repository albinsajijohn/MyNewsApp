package com.example.mynewsapp.data.repo

import com.example.mynewsapp.data.api.NewsApi
import javax.inject.Inject

class NewsRepo @Inject constructor(private val newsApi: NewsApi) {
    suspend fun getNews(apiKey: String,category: String) = newsApi.getTopHeadlines(apiKey = apiKey, category = category)


}