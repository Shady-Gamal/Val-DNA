package com.example.data.model

import com.example.domain.entities.MapItemDTO
import com.google.gson.annotations.SerializedName

data class MapsResponse(

	@field:SerializedName("data")
	val data: List<MapsDataItem>? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

data class MapsDataItem(

	@field:SerializedName("callouts")
	val callouts: List<CalloutsItem?>? = null,

	@field:SerializedName("displayName")
	val displayName: String? = null,

	@field:SerializedName("listViewIcon")
	val listViewIcon: String? = null,

	@field:SerializedName("coordinates")
	val coordinates: String? = null,

	@field:SerializedName("yScalarToAdd")
	val yScalarToAdd: Any? = null,

	@field:SerializedName("yMultiplier")
	val yMultiplier: Any? = null,

	@field:SerializedName("uuid")
	val uuid: String? = null,

	@field:SerializedName("displayIcon")
	val displayIcon: String? = null,

	@field:SerializedName("xMultiplier")
	val xMultiplier: Any? = null,

	@field:SerializedName("xScalarToAdd")
	val xScalarToAdd: Any? = null,

	@field:SerializedName("assetPath")
	val assetPath: String? = null,

	@field:SerializedName("mapUrl")
	val mapUrl: String? = null,

	@field:SerializedName("splash")
	val splash: String? = null
)

data class CalloutsItem(

	@field:SerializedName("superRegionName")
	val superRegionName: String? = null,

	@field:SerializedName("regionName")
	val regionName: String? = null,

	@field:SerializedName("location")
	val location: Location? = null
)

data class Location(

	@field:SerializedName("x")
	val x: Any? = null,

	@field:SerializedName("y")
	val y: Any? = null
)
fun MapsDataItem.toMapItemDTO() : MapItemDTO{

	return MapItemDTO(
		splash = splash,
		displayName = displayName
	)

}
