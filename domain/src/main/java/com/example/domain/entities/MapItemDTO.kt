package com.example.domain.entities

import android.location.Location


data class MapItemDTO(


    val callouts: List<CalloutsItemDTO?>? = null,


    val displayName: String? = null,


    val listViewIcon: String? = null,


    val coordinates: String? = null,


    val yScalarToAdd: Any? = null,


    val yMultiplier: Any? = null,


    val uuid: String? = null,


    val displayIcon: String? = null,


    val xMultiplier: Any? = null,


    val xScalarToAdd: Any? = null,


    val assetPath: String? = null,


    val mapUrl: String? = null,


    val splash: String? = null
)

data class CalloutsItemDTO(


    val superRegionName: String? = null,


    val regionName: String? = null,


    val location: Location? = null
)

data class LocationDTO(


    val x: Any? = null,


    val y: Any? = null
)
