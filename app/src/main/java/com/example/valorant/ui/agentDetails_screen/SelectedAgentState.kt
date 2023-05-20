package com.example.valorant.ui.agentDetails_screen

import com.example.domain.entities.AgentItemDTO

data class SelectedAgentState(
    val selectedAgentDetails :  AgentItemDTO ?= null,
    val isLoading : Boolean = false,
    val error: String ?= null
)