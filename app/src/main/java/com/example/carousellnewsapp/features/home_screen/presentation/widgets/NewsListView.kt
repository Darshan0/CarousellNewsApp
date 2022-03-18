package com.example.carousellnewsapp.features.home_screen.presentation.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.carousellnewsapp.core.models.NewsModel
import com.example.carousellnewsapp.core.theme.NewsTileBody
import com.example.carousellnewsapp.core.theme.NewsTileCreatedTime
import com.example.carousellnewsapp.core.theme.NewsTileHeading
import com.example.carousellnewsapp.core.utils.getTimeAgo
import java.util.*

@Composable
fun GetNewsListView(
    newsList: List<NewsModel>,
) {
    LazyColumn(
        modifier = Modifier.padding(all = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(
            items = newsList
        ) { news ->
            GetNewsListTile(news = news)
        }
    }
}

// ListItem
@ExperimentalCoilApi
@Composable
fun GetNewsListTile(news: NewsModel) =
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(7.dp),
        elevation = 2.dp,
    ) {
        Column() {
            news.bannerUrl?.let { bannerUrl ->
                Box(
                    modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = rememberImagePainter(bannerUrl),
                        contentDescription = "Banner Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            Column(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                news.title?.let { title ->
                    Row() {
                        Text(
                            title,
                            maxLines = 2,
                            style = MaterialTheme.typography.body1,
                            color = NewsTileHeading
                        )
                    }
                }

                news.description?.let { description ->
                    Row(
                        modifier = Modifier.padding(top = 4.dp, bottom = 8.dp)
                    ) {
                        Text(
                            description,
                            maxLines = 2,
                            style = MaterialTheme.typography.body2,
                            color = NewsTileBody
                        )
                    }
                }

                news.timeCreated?.let { timeCreated ->
                    Row() {
                        Text(
                            getTimeAgo(
                                Date(
                                    timeCreated.toLong()
                                )
                            ),
                            style = MaterialTheme.typography.caption,
                            color = NewsTileCreatedTime
                        )
                    }
                }
            }
        }
    }