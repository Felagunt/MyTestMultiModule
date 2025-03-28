package com.example.search.art_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.common.utils.Result
import com.example.search.art_list.ArtListAction
import com.example.search.art_list.ArtListState
import com.example.search.domain.model.ArtDetails
import com.example.search.domain.use_cases.GetArtDetailsUseCase
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
class ArtDetailsViewModel @Inject constructor(
    private val getArtDetailsUseCase: GetArtDetailsUseCase,
) : ViewModel() {



    private val _state = MutableStateFlow(ArtDetailsState())
    val state = _state
        .onStart {
            //getArtDetails(artId)
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _state.value
        )

    fun onAction(action: ArtDetailsAction) {
        when(action) {
            is ArtDetailsAction.FetchArtDetails -> {
                getArtDetails(action.id)
            }
            is ArtDetailsAction.OnNavigateBack -> {

            }
        }
    }

    private fun getArtDetails(id: Int) = getArtDetailsUseCase.invoke(id)
        .onEach { result ->
            when(result) {
                is Result.Error -> {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            errorMsg = result.message,
                            artDetails = null
                        )
                    }
                }
                is Result.Loading -> {
                    _state.update {
                        it.copy(
                            isLoading = true,
                            errorMsg = null,
                            artDetails = null
                        )
                    }
                }

                is Result.Success -> {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            errorMsg = null,
                            artDetails = result.data
                        )
                    }
                }
            }
        }
}