package com.example.search.domain.model

data class Art(
    val artist_display: String,
    val date_end: Int,
    val date_start: Int,
    val description: String,
    val id: Int,
    val image_id: String,
    val place_of_origin: String,
    val title: String
)