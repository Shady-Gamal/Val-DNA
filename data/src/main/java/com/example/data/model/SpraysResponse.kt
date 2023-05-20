package com.example.data.model

import com.example.domain.entities.SprayItemDTO
import com.google.gson.annotations.SerializedName

data class SpraysResponse(

	@field:SerializedName("data")
	val data: List<SpraysDataItem?>? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

data class SpraysDataItem(

	@field:SerializedName("displayIcon")
	val displayIcon: String? = null,

	@field:SerializedName("displayName")
	val displayName: String? = null,

	@field:SerializedName("assetPath")
	val assetPath: String? = null,

	@field:SerializedName("fullIcon")
	val fullIcon: String? = null,

	@field:SerializedName("animationGif")
	val animationGif: Any? = null,

	@field:SerializedName("category")
	val category: Any? = null,

	@field:SerializedName("uuid")
	val uuid: String? = null,

	@field:SerializedName("themeUuid")
	val themeUuid: Any? = null,

	@field:SerializedName("fullTransparentIcon")
	val fullTransparentIcon: String? = null,

	@field:SerializedName("animationPng")
	val animationPng: Any? = null,

	@field:SerializedName("levels")
	val levels: List<SpraysLevelsItem?>? = null
)

data class SpraysLevelsItem(

	@field:SerializedName("displayIcon")
	val displayIcon: String? = null,

	@field:SerializedName("displayName")
	val displayName: String? = null,

	@field:SerializedName("assetPath")
	val assetPath: String? = null,

	@field:SerializedName("uuid")
	val uuid: String? = null,

	@field:SerializedName("sprayLevel")
	val sprayLevel: Int? = null
)

fun SpraysDataItem.toSprayItemDTO() : SprayItemDTO{

	return SprayItemDTO(
		displayIcon = displayIcon
	)
}
