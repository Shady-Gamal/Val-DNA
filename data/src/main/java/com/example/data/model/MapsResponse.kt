package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.entities.MapItemDTO
import com.google.gson.annotations.SerializedName

data class MapsResponse(

	@field:SerializedName("data")
	val data: List<MapsDataItem>? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

@Entity
data class MapsDataItem(

	@field:SerializedName("callouts")
	val callouts: List<CalloutsItem?>? = null,

	@field:SerializedName("displayName")
	val displayName: String? = null,

	@field:SerializedName("tacticalDescription")
	val tacticalDescription: String? = null,

	@field:SerializedName("listViewIcon")
	val listViewIcon: String? = null,

	@field:SerializedName("coordinates")
	val coordinates: String? = null,

	@field:SerializedName("yScalarToAdd")
	val yScalarToAdd: Float? = null,

	@field:SerializedName("yMultiplier")
	val yMultiplier: String? = null,

	@PrimaryKey
	@field:SerializedName("uuid")
	val uuid: String,

	@field:SerializedName("narrativeDescription")
	val narrativeDescription: String? = null,

	@field:SerializedName("displayIcon")
	val displayIcon: String? = null,

	@field:SerializedName("xMultiplier")
	val xMultiplier: String? = null,

	@field:SerializedName("xScalarToAdd")
	val xScalarToAdd: Float? = null,

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
		displayName = displayName,
		mapUrl = mapUrl,
		coordinates = coordinates,
		displayIcon = displayIcon,
		narrativeDescription = narrativeDescription,
		tacticalDescription = tacticalDescription

	)

}
