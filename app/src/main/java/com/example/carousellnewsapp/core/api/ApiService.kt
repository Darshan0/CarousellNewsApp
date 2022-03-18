package com.example.carousellnewsapp.core.api

import com.example.carousellnewsapp.core.models.NewsModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(value = "android/carousell_news.json")
    suspend fun getNews() : List<NewsModel>
}

