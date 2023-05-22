package com.example.valorant.ui.sprays_screen


import android.os.Parcelable
import com.example.domain.entities.AgentItemDTO
import com.example.domain.entities.MapItemDTO
import com.example.domain.entities.SprayItemDTO
import com.example.domain.entities.WeaponItemDTO
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

data class SpraysState(
    val spraysInfo : List<SprayItemDTO> ?= null,
    val isLoading : Boolean = false,
    val error: String ?= null
)