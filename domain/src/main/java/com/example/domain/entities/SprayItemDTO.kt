package com.example.domain.entities

data class SprayItemDTO(


    val displayIcon: String? = null,


    val displayName: String? = null,


    val assetPath: String? = null,


    val fullIcon: String? = null,


    val animationGif: Any? = null,


    val category: Any? = null,


    val uuid: String? = null,


    val themeUuid: Any? = null,


    val fullTransparentIcon: String? = null,


    val animationPng: Any? = null,


    val levels: List<SprayLevelsItem?>? = null
)

data class SprayLevelsItem(


    val displayIcon: String? = null,


    val displayName: String? = null,


    val assetPath: String? = null,


    val uuid: String? = null,


    val sprayLevel: Int? = null
)
