package com.example.carousellnewsapp.core.di

import com.example.carousellnewsapp.core.api.ApiHelper
import com.example.carousellnewsapp.features.home_screen.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(
        apiHelper: ApiHelper
    ) : NewsRepository{
        return NewsRepository(apiHelper = apiHelper)
    }
}