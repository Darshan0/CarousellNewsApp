package com.example.carousellnewsapp.core.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.carousellnewsapp.R

val Roboto = FontFamily(
    Font(R.font.roboto_regular,FontWeight.Normal),
    Font(R.font.roboto_medium, FontWeight.Bold),
)

// Set of Material typography styles to start with
val Typography = Typography(
    Roboto,
    h6 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
    ),
    body2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    caption = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
    )

)

