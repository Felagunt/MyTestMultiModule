package com.example.search.art_details

import com.example.search.domain.model.ArtDetails

data class ArtDetailsState(
    val isLoading: Boolean = false,
    val errorMsg: String? = null,
    val artDetails: ArtDetails? = null
)
