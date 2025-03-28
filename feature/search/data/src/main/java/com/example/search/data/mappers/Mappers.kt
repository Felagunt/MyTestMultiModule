package com.example.search.data.mappers

import com.example.search.data.dto.Data
import com.example.search.domain.model.Art

fun Data.toArt(): Art {
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