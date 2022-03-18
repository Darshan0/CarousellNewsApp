package com.example.carousellnewsapp.ui.features

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.carousellnewsapp.features.home_screen.presentation.widgets.GetDefaultAppBar
import com.example.carousellnewsapp.features.home_screen.presentation.widgets.GetNewsListView
import com.example.carousellnewsapp.features.home_screen.usecases.NewsViewModel


@Composable
fun GetHomeScreen(
    newsViewModel: NewsViewModel,
) {
    Scaffold(
        topBar = {
            GetDefaultAppBar(
                onSortActionClicked = { action ->
                    newsViewModel.getSortedNewList(action = action)
                },
            )
        },
        content = {
            val newList by newsViewModel.news.observeAsState(listOf())

            if (newList.isEmpty()) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator()
                }
            } else {
                GetNewsListView(newsList = newList)
            }
        },
    )
}


// List of ads : 1 ) For every three tiles add ads card;  (type ?? news : ads)
// LazyColumn length = ads Length + news Length
// call Ads Api in viewModel init // user flows








