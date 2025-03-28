package com.example.search.data.remote

import com.example.search.data.dto.ResponseDto
import com.example.search.data.dto.details.DetailsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SearchArtApiService {
    //https://api.artic.edu/api/v1/

    @GET("artworks?page={number}&fields=id,title,image_id,date_start,date_end,artist_display,place_of_origin,description")
    suspend fun getInitialPage(@Path("number") number: Int): Response<ResponseDto>

    @GET("artworks/{id}")
    suspend fun getArtDetails(@Path("id")id: Int): Response<DetailsResponse>
}