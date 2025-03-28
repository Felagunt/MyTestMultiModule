package com.example.search.art_list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.search.art_list.components.ArtListItem
import com.example.search.domain.model.Art

@Composable
fun ArtListScreenRoot(
    modifier: Modifier,
    viewModel: ArtListViewModel = hiltViewModel(),
    onClickArt: (Art) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    ArtListScreen(
        modifier = modifier,
        state = state,
        onAction = { action ->
            when (action) {
                is ArtListAction.OnArtClick -> onClickArt(action.art)
                else -> Unit
            }
            viewModel.onAction(action)
        }
    )

}

@Composable
private fun ArtListScreen(
    modifier: Modifier,
    state: ArtListState,
    onAction: (ArtListAction) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.surface)
            )
        }
        if (state.errorMsg!!.isNotEmpty()) {
            Text(
                text = state.errorMsg,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.background(MaterialTheme.colorScheme.surface)
            )
        }

        state.artsList?.let { list ->
            if (list.isNotEmpty()) {
                LazyColumn(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(12.dp)
                ) {
                    items(list) { art ->
                        ArtListItem(
                            art = art,
                            modifier = Modifier
                                .clickable {
                                    onAction(ArtListAction.OnArtClick(art))
                                }
                        )
                    }
                }
            }
        }
    }
}