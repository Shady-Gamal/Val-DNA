package com.example.valorant.ui.home_screen


import android.os.Parcelable
import com.example.domain.entities.*
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

data class HomeState(
    val agentsInfo :  List<AgentItemDTO> ?= null,
    val weaponsInfo :  List<WeaponItemDTO> ?= null,
    val mapsInfo : List<MapItemDTO> ?= null,
    val playerCardsInfo : List<PlayerCardItemDTO> ?= null,
    val bundlesInfo : List<BundleItemDTO> ?= null,
    val isLoading : Boolean = false,
    val error: String ?= null
)