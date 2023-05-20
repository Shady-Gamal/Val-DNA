package com.example.domain.entities

data class BuddyItemDTO(


    val displayIcon: String? = null,


    val displayName: String? = null,

    val assetPath: String? = null,


    val uuid: String? = null,


    val themeUuid: Any? = null,


    val isHiddenIfNotOwned: Boolean? = null,


    val levels: List<BuddiesLevelsItem?>? = null
)

data class BuddiesLevelsItem(


    val displayIcon: String? = null,


    val charmLevel: Int? = null,


    val displayName: String? = null,


    val assetPath: String? = null,


    val uuid: String? = null
)