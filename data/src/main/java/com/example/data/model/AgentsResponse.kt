package com.example.data.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.entities.AgentItemDTO
import com.example.domain.entities.RoleDTO



import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.RawValue

@Parcelize
data class AgentsResponse(

	@field:SerializedName("data")
	val data: List<AgentsDataItem>? = null,

	@field:SerializedName("status")
	val status: Int? = null
) : Parcelable

@Parcelize
data class VoiceLine(

	@field:SerializedName("minDuration")
	val minDuration: @RawValue Any? = null,

	@field:SerializedName("mediaList")
	val mediaList: List<MediaListItem?>? = null,

	@field:SerializedName("maxDuration")
	val maxDuration: @RawValue Any? = null
) : Parcelable

@Parcelize
@Entity
data class AgentsDataItem(

	@field:SerializedName("killfeedPortrait")
	val killfeedPortrait: String? = null,

	@field:SerializedName("role")
	val role: Role? = null,

	@field:SerializedName("isFullPortraitRightFacing")
	val isFullPortraitRightFacing: Boolean? = null,

	@field:SerializedName("displayName")
	val displayName: String? = null,

	@field:SerializedName("isBaseContent")
	val isBaseContent: Boolean? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("backgroundGradientColors")
	val backgroundGradientColors: List<String?>? = null,

	@field:SerializedName("isAvailableForTest")
	val isAvailableForTest: Boolean? = null,

	@PrimaryKey
	@field:SerializedName("uuid")
	val uuid: String,

	@field:SerializedName("characterTags")
	val characterTags: List<String>? = null,

	@field:SerializedName("displayIconSmall")
	val displayIconSmall: String? = null,

	@field:SerializedName("fullPortrait")
	val fullPortrait: String? = null,

	@field:SerializedName("fullPortraitV2")
	val fullPortraitV2: String? = null,

	@field:SerializedName("abilities")
	val abilities: List<AbilitiesItem?>? = null,

	@field:SerializedName("displayIcon")
	val displayIcon: String? = null,

	@field:SerializedName("bustPortrait")
	val bustPortrait: String? = null,

	@field:SerializedName("background")
	val background: String? = null,

	@field:SerializedName("assetPath")
	val assetPath: String? = null,

	@field:SerializedName("voiceLine")
	val voiceLine: VoiceLine? = null,

	@field:SerializedName("isPlayableCharacter")
	val isPlayableCharacter: Boolean? = null,

	@field:SerializedName("developerName")
	val developerName: String? = null
) : Parcelable

@Parcelize
data class Role(

	@field:SerializedName("displayIcon")
	val displayIcon: String? = null,

	@field:SerializedName("displayName")
	val displayName: String? = null,

	@field:SerializedName("assetPath")
	val assetPath: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("uuid")
	val uuid: String? = null
) : Parcelable

@Parcelize
data class AbilitiesItem(

	@field:SerializedName("displayIcon")
	val displayIcon: String? = null,

	@field:SerializedName("displayName")
	val displayName: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("slot")
	val slot: String? = null
) : Parcelable

@Parcelize
data class MediaListItem(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("wave")
	val wave: String? = null,

	@field:SerializedName("wwise")
	val wwise: String? = null
) : Parcelable

fun AgentsDataItem.toAgentItemDTO() : AgentItemDTO {

	return AgentItemDTO(
		displayName = displayName,
		fullPortrait = fullPortrait,
		role = role?.toRoleDTO() ,
		background = background,
		description = description,
		displayIcon = displayIcon,
		uuid = uuid
		)
}

fun Role.toRoleDTO() : RoleDTO{

	return RoleDTO(
		displayIcon = displayIcon,
		displayName = displayName,
		assetPath = assetPath,
		description = description,
		uuid= uuid
	)
}

