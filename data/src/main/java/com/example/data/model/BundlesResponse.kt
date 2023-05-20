package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.entities.BundleItemDTO
import com.google.gson.annotations.SerializedName

data class BundlesResponse(

	@field:SerializedName("data")
	val data: List<BundlesDataItem>? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

@Entity
data class BundlesDataItem(

	@field:SerializedName("displayNameSubText")
	val displayNameSubText: String? = null,

	@field:SerializedName("extraDescription")
	val extraDescription: String? = null,

	@field:SerializedName("displayIcon")
	val displayIcon: String? = null,

	@field:SerializedName("displayName")
	val displayName: String? = null,

	@field:SerializedName("assetPath")
	val assetPath: String? = null,

	@field:SerializedName("useAdditionalContext")
	val useAdditionalContext: Boolean? = null,

	@field:SerializedName("verticalPromoImage")
	val verticalPromoImage: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@PrimaryKey
	@field:SerializedName("uuid")
	val uuid: String,

	@field:SerializedName("promoDescription")
	val promoDescription: String? = null,

	@field:SerializedName("displayIcon2")
	val displayIcon2: String? = null
)

fun BundlesDataItem.toBundleItemDTO() : BundleItemDTO{

	return BundleItemDTO(
		displayName = displayName,
		displayIcon = displayIcon


	)
}