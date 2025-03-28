package com.example.search.domain.repository

import com.example.search.domain.model.Art

interface SearchRepository {

    suspend fun getPageWithArts(number: Int): Result<List<Art>>
}