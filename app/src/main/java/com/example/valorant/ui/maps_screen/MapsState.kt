package com.example.valorant.ui.maps_screen

import com.example.domain.entities.AgentItemDTO
import com.example.domain.entities.BundleItemDTO
import com.example.domain.entities.MapItemDTO

data class MapsState(
    val mapsInfo :  List<MapItemDTO> ?= null,
    val isLoading : Boolean = false,
    val error: String ?= null
)