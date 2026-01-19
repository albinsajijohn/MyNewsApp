package com.example.mynewsapp.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynewsapp.data.model.Article
import com.example.mynewsapp.data.repo.NewsRepo

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsVm @Inject constructor(
    private val newsRepo: NewsRepo
) : ViewModel() {

    private val _news = MutableStateFlow<List<Article>>(emptyList())
    val news: StateFlow<List<Article>> = _news

    private val _selectedCategory = MutableStateFlow("business")
    val selectedCategory: StateFlow<String> = _selectedCategory

    fun getNews(apiKey: String, category: String = _selectedCategory.value) {
        viewModelScope.launch {
            try {
                val response = newsRepo.getNews(apiKey, category)
                _news.value = response.articles
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun changeCategory(apiKey: String, category: String) {
        _selectedCategory.value = category
        getNews(apiKey, category)
    }
}
