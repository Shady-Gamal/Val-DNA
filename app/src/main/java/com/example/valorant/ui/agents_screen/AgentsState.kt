package com.example.valorant.ui.agents_screen

import com.example.domain.entities.AgentItemDTO

data class AgentsState(
    val agentsInfo :  List<AgentItemDTO> ?= null,
    val isLoading : Boolean = false,
    val error: String ?= null
)