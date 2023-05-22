package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.entities.BuddyItemDTO
import com.google.gson.annotations.SerializedName

data class BuddiesResponse(

	@field:SerializedName("data")
	val data: List<BuddiesDataItem>? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

@Entity
data class BuddiesDataItem(

	@field:SerializedName("displayIcon")
	val displayIcon: String? = null,

	@field:SerializedName("displayName")
	val displayName: String? = null,

	@field:SerializedName("assetPath")
	val assetPath: String? = null,

	@PrimaryKey
	@field:SerializedName("uuid")
	val uuid: String,

	@field:SerializedName("themeUuid")
	val themeUuid: String? = null,

	@field:SerializedName("isHiddenIfNotOwned")
	val isHiddenIfNotOwned: Boolean? = null,

	@field:SerializedName("levels")
	val levels: List<BuddiesLevelsItem?>? = null
)

data class BuddiesLevelsItem(

	@field:SerializedName("displayIcon")
	val displayIcon: String? = null,

	@field:SerializedName("charmLevel")
	val charmLevel: Int? = null,

	@field:SerializedName("displayName")
	val displayName: String? = null,

	@field:SerializedName("assetPath")
	val assetPath: String? = null,

	@field:SerializedName("uuid")
	val uuid: String? = null
)

fun BuddiesDataItem.toBuddyItemDTO() : BuddyItemDTO {

	return BuddyItemDTO(
displayIcon = displayIcon,
		displayName = displayName

	)
}