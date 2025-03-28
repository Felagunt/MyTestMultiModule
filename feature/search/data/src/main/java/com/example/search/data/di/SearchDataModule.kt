package com.example.search.data.di

import com.example.search.data.remote.SearchArtApiService
import com.example.search.data.repository.SearchRepositoryImpl
import com.example.search.domain.repository.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

const val BASE_URL = "https://api.artic.edu/api/v1/"

@Module
@InstallIn(SingletonComponent::class)
object SearchDataModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideSearchApiService(retrofit: Retrofit): SearchArtApiService {
        return retrofit.create(SearchArtApiService::class.java)
    }

    @Provides
    fun provideSearchRepository(apiService: SearchArtApiService): SearchRepository {
        return SearchRepositoryImpl(apiService)
    }
}