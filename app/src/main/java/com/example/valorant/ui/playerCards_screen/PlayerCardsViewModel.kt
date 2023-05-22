package com.example.valorant.ui.playerCards_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Resource
import com.example.domain.usecases.GetPlayerCardsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayerCardsViewModel @Inject constructor(
    val getPlayerCardsUseCase: GetPlayerCardsUseCase
) : ViewModel() {
    var playerCardsState by mutableStateOf(PlayerCardsState())

    init {
        getPlayerCards()
    }
    fun getPlayerCards(){

        viewModelScope.launch {
            getPlayerCardsUseCase.invoke().collect{
                when (it){
                    is Resource.Success -> playerCardsState = playerCardsState.copy(
                        playerCardsInfo = it.data
                    )
                    is Resource.Error -> playerCardsState = playerCardsState.copy(
                        error = it.message
                    )
                    is Resource.Loading -> playerCardsState = playerCardsState.copy(
                        isLoading = true
                    )

                }
            }
        }
    }

}