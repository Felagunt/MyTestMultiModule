package com.example.search.data.dto

data class ResponseDto(
    val config: Config,
    val `data`: List<Data>,
    val info: Info,
    val pagination: Pagination
)