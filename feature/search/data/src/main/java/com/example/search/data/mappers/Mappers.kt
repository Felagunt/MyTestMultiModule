package com.example.search.data.mappers

import com.example.search.data.dto.DataDto
import com.example.search.data.dto.details.Data
import com.example.search.domain.model.Art
import com.example.search.domain.model.ArtDetails

fun DataDto.toArt(): Art {
    return Art(
        artist_display = artist_display,
        date_end = date_end,
        date_start = date_start,
        description = description,
        id = id,
        image_id = image_id,
        place_of_origin = place_of_origin,
        title = title
    )
}

fun Data.toArtDetails(): ArtDetails {
    return ArtDetails(
        artistDisplay = artist_display,
        dateEnd = date_end,
        dateStart = date_start,
        description = description,
        id = id,
        imageId = image_id,
        placeOfOrigin = place_of_origin,
        title = title
    )
}