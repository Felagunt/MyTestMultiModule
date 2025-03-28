package com.example.search.domain.repository

import com.example.search.domain.model.Art
import com.example.search.domain.model.ArtDetails

interface SearchRepository {

    suspend fun getPageWithArts(number: Int): Result<List<Art>>

    suspend fun getArtDetails(id: Int): Result<ArtDetails>
}