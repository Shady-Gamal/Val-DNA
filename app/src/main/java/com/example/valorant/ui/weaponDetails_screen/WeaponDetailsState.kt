package com.example.valorant.ui.weaponDetails_screen

import com.example.domain.entities.WeaponItemDTO

data class WeaponDetailsState(
    val selectedWeaponDetails :  WeaponItemDTO ?= null,
    val isLoading : Boolean = false,
    val error: String ?= null
)