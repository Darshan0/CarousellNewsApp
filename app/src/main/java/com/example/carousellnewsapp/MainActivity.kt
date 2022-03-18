package com.example.carousellnewsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.carousellnewsapp.core.theme.CarousellNewsAppTheme
import com.example.carousellnewsapp.features.home_screen.usecases.NewsViewModel
import com.example.carousellnewsapp.ui.features.GetHomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val newsViewModel: NewsViewModel by viewModels<NewsViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarousellNewsAppTheme {
                GetHomeScreen(newsViewModel = newsViewModel)
            }
        }
    }
}