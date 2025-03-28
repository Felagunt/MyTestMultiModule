package com.example.search.art_details

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.search.domain.model.Art

@Composable
fun ArtDetailsScreenRoot(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    ArtDetailsScreenRoot(
        modifier = modifier,
        onClick = onClick
    )
}

@Composable
private fun ArtDetailsScreen(
    modifier: Modifier,
    onClick: () -> Unit
) {

    Text(
        text = "Art Details",
        modifier = modifier
            .clickable {
                onClick()
            }
    )
}