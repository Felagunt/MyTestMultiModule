package com.example.search.domain.model

data class ArtDetails(
    val artistDisplay: String,
    val dateEnd: Int,
    val dateStart: Int,
    val description: String,
    val id: Int,
    val imageId: String,
    val placeOfOrigin: String,
    val title: String
)