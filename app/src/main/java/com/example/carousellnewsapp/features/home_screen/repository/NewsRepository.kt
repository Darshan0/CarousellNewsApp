package com.example.carousellnewsapp.features.home_screen.repository

import com.example.carousellnewsapp.core.api.ApiHelper
import javax.inject.Inject
import javax.inject.Singleton

class NewsRepository @Inject constructor(
    private val apiHelper: ApiHelper
) {
    suspend fun getNews() = apiHelper.getNews()
}