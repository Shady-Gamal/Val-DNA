package com.example.valorant.ui.home_screen


import android.os.Parcelable
import com.example.domain.entities.AgentItemDTO
import com.example.domain.entities.MapItemDTO
import com.example.domain.entities.WeaponItemDTO
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

data class HomeState(
    val agentsInfo :  List<AgentItemDTO> ?= null,
    val weaponsInfo :  List<WeaponItemDTO> ?= null,
    val mapsInfo : List<MapItemDTO> ?= null,
    val isLoading : Boolean = false,
    val error: String ?= null
)