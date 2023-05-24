package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.entities.PlayerCardItemDTO
import com.google.gson.annotations.SerializedName

data class PlayerCardsResponse(

	@field:SerializedName("data")
	val data: List<PlayerCardsDataItem>? = null,

	@field:SerializedName("status")
	val status: Int? = null
)
@Entity
data class PlayerCardsDataItem(

	@field:SerializedName("displayIcon")
	val displayIcon: String? = null,

	@field:SerializedName("wideArt")
	val wideArt: String? = null,

	@field:SerializedName("smallArt")
	val smallArt: String? = null,

	@field:SerializedName("displayName")
	val displayName: String? = null,

	@field:SerializedName("largeArt")
	val largeArt: String? = null,

	@field:SerializedName("assetPath")
	val assetPath: String? = null,

	@PrimaryKey
	@field:SerializedName("uuid")
	val uuid: String,

	@field:SerializedName("themeUuid")
	val themeUuid: String? = null,

	@field:SerializedName("isHiddenIfNotOwned")
	val isHiddenIfNotOwned: Boolean? = null
)

fun PlayerCardsDataItem.toPlayerCardItemDTO() : PlayerCardItemDTO{
	return PlayerCardItemDTO(
		displayIcon = displayIcon,
		largeArt = largeArt,
		smallArt = smallArt,
		wideArt = wideArt,
		displayName = displayName
	)
}