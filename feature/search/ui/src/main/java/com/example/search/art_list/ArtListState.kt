package com.example.search.art_list

import com.example.search.domain.model.Art

data class ArtListState(
    val artsList: List<Art>? = emptyList(),
    val isLoading: Boolean = false,
    val errorMsg: String? = null
)