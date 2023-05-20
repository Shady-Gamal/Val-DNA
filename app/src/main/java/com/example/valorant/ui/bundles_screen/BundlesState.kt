package com.example.valorant.ui.bundles_screen

import com.example.domain.entities.AgentItemDTO
import com.example.domain.entities.BundleItemDTO

data class BundlesState(
    val bundlesInfo :  List<BundleItemDTO> ?= null,
    val isLoading : Boolean = false,
    val error: String ?= null
)