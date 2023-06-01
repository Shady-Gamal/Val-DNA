package com.example.valorant.ui.weaponSkins_screen

import com.example.domain.entities.WeaponItemDTO

data class WeaponSkinsState(
    val WeaponSkins :  WeaponItemDTO ?= null,
    val isLoading : Boolean = false,
    val error: String ?= null
)