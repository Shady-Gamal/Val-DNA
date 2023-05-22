package com.example.valorant.ui.buddies_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Resource
import com.example.domain.usecases.GetBuddiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BuddiesViewModel @Inject constructor(
    val getBuddiesUseCase: GetBuddiesUseCase
) : ViewModel() {
    var buddiesState by mutableStateOf(BuddiesState())

    init{
        getBuddies()
    }

    fun getBuddies(){

        viewModelScope.launch {
            getBuddiesUseCase.invoke().collect() {

                when (it) {
                    is Resource.Success -> buddiesState = buddiesState.copy(
                        buddiesInfo = it.data
                    )
                    is Resource.Error -> buddiesState = buddiesState.copy(
                        error = it.message
                    )
                    is Resource.Loading -> buddiesState = buddiesState.copy(
                        isLoading = true
                    )

                }
            }
        }
    }
}