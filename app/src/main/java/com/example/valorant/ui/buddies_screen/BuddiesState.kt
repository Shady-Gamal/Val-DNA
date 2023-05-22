package com.example.valorant.ui.buddies_screen


import com.example.domain.entities.BuddyItemDTO

data class BuddiesState(
    val buddiesInfo :  List<BuddyItemDTO> ?= null,
    val isLoading : Boolean = false,
    val error: String ?= null
)