package com.example.search.art_list.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.search.domain.model.Art


@Composable
fun ArtListItem(
    modifier: Modifier = Modifier,
    art: Art
) {

    ListItem(
        modifier = modifier,
        headlineContent = {
            Text(
                text = art.title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        },
        leadingContent = {
            AsyncImage(
                model = art.image_id,
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
        },
        supportingContent = {
            Text(
                text = art.description,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
                style = MaterialTheme.typography.bodySmall
            )
        }
    )
}

//val artist_display: String,
//val date_end: Int,
//val date_start: Int,
//val description: String,
//val id: Int,
//val image_id: String,
//val place_of_origin: String,
//val title: String
//)