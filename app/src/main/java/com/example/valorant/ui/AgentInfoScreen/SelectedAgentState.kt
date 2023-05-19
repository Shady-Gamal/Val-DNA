package com.example.valorant.ui.AgentInfoScreen

import com.example.domain.entities.AgentItemDTO
import com.example.domain.entities.MapItemDTO
import com.example.domain.entities.WeaponItemDTO

data class SelectedAgentState(
    val selectedAgentDetails :  AgentItemDTO ?= null,
    val isLoading : Boolean = false,
    val error: String ?= null
)