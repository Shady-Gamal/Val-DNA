package com.example.data.model

import com.example.domain.entities.PlayerTitleDTO
import com.google.gson.annotations.SerializedName

data class PlayerTitlesResponse(

	@field:SerializedName("data")
	val data: List<PlayerTitlesDataItem?>? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

data class PlayerTitlesDataItem(

	@field:SerializedName("displayName")
	val displayName: String? = null,

	@field:SerializedName("assetPath")
	val assetPath: String? = null,

	@field:SerializedName("titleText")
	val titleText: String? = null,

	@field:SerializedName("uuid")
	val uuid: String? = null,

	@field:SerializedName("isHiddenIfNotOwned")
	val isHiddenIfNotOwned: Boolean? = null
)

fun PlayerTitlesDataItem.toPlayerTitleDTO() : PlayerTitleDTO{

	return PlayerTitleDTO(
		displayName = displayName,
	)
}
