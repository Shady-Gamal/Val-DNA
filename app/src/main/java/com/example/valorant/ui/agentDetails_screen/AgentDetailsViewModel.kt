package com.example.valorant.ui.agentDetails_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Resource
import com.example.domain.usecases.GetSelectedAgentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getSelectedAgentUseCase: GetSelectedAgentUseCase
) : ViewModel() {

    var agentDetailsState by mutableStateOf(AgentDetailsState())

    init {
       savedStateHandle.get<String>("agentId")?.let {  agentId ->
            getSelectedAgentDetails(agentId)
        }
    }

    fun getSelectedAgentDetails(uuid : String){
        viewModelScope.launch {
            getSelectedAgentUseCase.invoke(uuid).collect{

                when (it){
                    is Resource.Success -> agentDetailsState = agentDetailsState.copy(
                        selectedAgentDetails = it.data
                )
                    is Resource.Loading -> agentDetailsState = agentDetailsState.copy(
                        isLoading = true
                    )
                    is Resource.Error -> agentDetailsState = agentDetailsState.copy(
                        error = it.message
                    )

                }
            }
        }


    }


}