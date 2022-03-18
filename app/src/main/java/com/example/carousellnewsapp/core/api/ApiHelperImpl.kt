package com.example.carousellnewsapp.core.api

import com.example.carousellnewsapp.core.models.NewsModel
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(
    private val apiService: ApiService
) : ApiHelper {
    override suspend fun getNews(): List<NewsModel> = apiService.getNews()
}