package com.example.mynewsapp.data.api

import com.example.mynewsapp.data.model.NewsReport
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsApi {
    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String="us",
        @Query("category") category: String,
        @Query("apiKey") apiKey: String,


    ): NewsReport

}