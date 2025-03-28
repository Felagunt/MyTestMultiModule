package com.example.search.art_list

import com.example.search.domain.model.Art

sealed class ArtListAction {
    data class OnArtClick(val art: Art) : ArtListAction()
    data class OnNextPageClick(val pageNumber: Int): ArtListAction()
}