package com.example.carousellnewsapp.core.api

import com.example.carousellnewsapp.core.models.NewsModel
import retrofit2.Response

interface ApiHelper {
    suspend fun getNews():List<NewsModel>
}