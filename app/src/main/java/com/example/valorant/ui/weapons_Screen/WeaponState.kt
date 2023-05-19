package com.example.valorant.ui.weapons_Screen

import com.example.domain.entities.AgentItemDTO
import com.example.domain.entities.MapItemDTO
import com.example.domain.entities.WeaponItemDTO
import kotlinx.parcelize.RawValue

data class WeaponState(
    val weaponsInfo :  List<WeaponItemDTO> ?= null,
    val isLoading : Boolean = false,
    val error: String ?= null
)