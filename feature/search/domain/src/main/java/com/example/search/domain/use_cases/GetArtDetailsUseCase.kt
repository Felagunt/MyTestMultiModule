package com.example.search.domain.use_cases

import com.example.common.utils.Result
import com.example.search.domain.repository.SearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetArtDetailsUseCase @Inject constructor(
    private val repository: SearchRepository
) {
    operator fun invoke(id: Int) = flow {
        emit(Result.Loading())
        val response = repository.getArtDetails(id)
        if(response.isSuccess) {
            emit(Result.Success(data = response.getOrThrow()))
        } else {
            emit(Result.Error(message = response.exceptionOrNull()?.localizedMessage))
        }
    }.catch {
        emit(Result.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}