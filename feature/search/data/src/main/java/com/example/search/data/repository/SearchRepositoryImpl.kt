package com.example.search.data.repository

import com.example.search.data.mappers.toArt
import com.example.search.data.mappers.toArtDetails
import com.example.search.data.remote.SearchArtApiService
import com.example.search.domain.model.Art
import com.example.search.domain.model.ArtDetails
import com.example.search.domain.repository.SearchRepository

class SearchRepositoryImpl(
    private val api: SearchArtApiService
): SearchRepository {

    override suspend fun getPageWithArts(number: Int): Result<List<Art>> {
        return try {
            val response = api.getInitialPage(number)
            if (response.isSuccessful) {
                response.body()?.data?.let {list ->
                    Result.success(
                        list
                            .map { it.toArt() }
                    )
                } ?: run { Result.failure(Exception("Error")) }
            } else {
                Result.failure(Exception("Smth wrong"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getArtDetails(id: Int): Result<ArtDetails> {
        return try {
            val response = api.getArtDetails(id)
            if (response.isSuccessful) {
                response.body()?.data?.let {dto ->
                    Result.success(
                            dto.toArtDetails()
                    )
                } ?: run { Result.failure(Exception("Error")) }
            } else {
                Result.failure(Exception("Smth wrong"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }


}