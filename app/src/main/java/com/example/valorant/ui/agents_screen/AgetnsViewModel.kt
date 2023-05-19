package com.example.valorant.ui.agents_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Resource
import com.example.domain.usecases.GetAgentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgetnsViewModel @Inject constructor(
   val getAgentsUseCase: GetAgentsUseCase
) : ViewModel() {
var agentsState by mutableStateOf(AgentsState())


    init {
        getAgents()
    }


fun getAgents(){
    viewModelScope.launch {
        getAgentsUseCase.invoke().collect(){
            when (it){

                is Resource.Success -> agentsState = agentsState.copy(
                    agentsInfo = it.data
                )
                is Resource.Error -> agentsState = agentsState.copy(
                    error = it.message
                )
                is Resource.Loading -> agentsState = agentsState.copy(
                    isLoading = true
                )
            }
        }
    }



}




}