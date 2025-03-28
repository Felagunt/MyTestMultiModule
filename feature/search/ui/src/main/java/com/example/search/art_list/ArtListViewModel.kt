package com.example.search.art_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.utils.Result
import com.example.search.domain.use_cases.GetPageOfArtUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ArtListViewModel @Inject constructor(
    private val getPageOfArtUseCase: GetPageOfArtUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(ArtListState())
    val state = _state
        .onStart {
            getPageOfArt(1)
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _state.value
        )

    fun onAction(action: ArtListAction) {
        when(action) {
            is ArtListAction.OnArtClick -> {

            }
            is ArtListAction.OnNextPageClick -> {
                getPageOfArt(action.pageNumber)
            }
        }
    }

    private fun getPageOfArt(number: Int) = getPageOfArtUseCase.invoke(number)
        .onEach { result ->
            when(result) {
                is Result.Error -> {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            errorMsg = result.message,
                            artsList = emptyList()
                        )
                    }
                }
                is Result.Loading -> {
                    _state.update {
                        it.copy(
                            isLoading = true,
                            errorMsg = null,
                            artsList = emptyList()
                        )
                    }
                }

                is Result.Success -> {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            errorMsg = null,
                            artsList = result.data
                        )
                    }
                }
            }
        }
}