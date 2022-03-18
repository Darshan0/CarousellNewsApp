package com.example.carousellnewsapp.features.home_screen.usecases

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carousellnewsapp.core.eums.Action
import com.example.carousellnewsapp.core.models.NewsModel
import com.example.carousellnewsapp.features.home_screen.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@InternalCoroutinesApi
@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {
    private val _news : MutableLiveData<List<NewsModel>> = MutableLiveData()

    val news : LiveData<List<NewsModel>> get() = _news;

    init {
        viewModelScope.launch {
            val result = newsRepository.getNews()
            _news.value = result
        }

    }

    fun getSortedNewList(action: Action) {
        when (action) {
            Action.Recent -> {
                _news.value = _news.value?.sortedBy { it.timeCreated }
            }
            Action.Popular -> {
                val sortedNewsList = _news.value?.sortedWith(
                    compareBy<NewsModel>(
                        {it.rank},
                        {it.timeCreated}
                    )
                )
                _news.value = sortedNewsList
            }
        }
    }
}