package com.example.valorant.ui.AgentInfoScreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.AgentItemDTO
import com.example.domain.entities.Resource
import com.example.domain.usecases.GetSelectedAgentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentInfoViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getSelectedAgentUseCase: GetSelectedAgentUseCase
) : ViewModel() {

    var selectedAgentState by mutableStateOf(SelectedAgentState())

    init {
       savedStateHandle.get<String>("agentId")?.let {  agentId ->
            getSelectedAgentDetails(agentId)
        }
    }

    fun getSelectedAgentDetails(uuid : String){
        viewModelScope.launch {
            getSelectedAgentUseCase.invoke(uuid).collect{

                when (it){
                    is Resource.Success -> selectedAgentState = selectedAgentState.copy(
                        selectedAgentDetails = it.data
                )
                    is Resource.Loading -> selectedAgentState = selectedAgentState.copy(
                        isLoading = true
                    )
                    is Resource.Error -> selectedAgentState = selectedAgentState.copy(
                        error = it.message
                    )

                }
            }
        }


    }


}