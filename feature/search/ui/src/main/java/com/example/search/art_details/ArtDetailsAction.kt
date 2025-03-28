package com.example.search.art_details

sealed class ArtDetailsAction {
    data class FetchArtDetails(val id: Int) : ArtDetailsAction()
    data object OnNavigateBack: ArtDetailsAction()
}