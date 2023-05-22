package com.example.valorant.ui.playerCards_screen

import com.example.domain.entities.AgentItemDTO
import com.example.domain.entities.BundleItemDTO
import com.example.domain.entities.PlayerCardItemDTO

data class PlayerCardsState(
    val playerCardsInfo :  List<PlayerCardItemDTO> ?= null,
    val isLoading : Boolean = false,
    val error: String ?= null
)