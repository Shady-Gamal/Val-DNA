package com.example.data.model

import androidx.room.DatabaseView
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.entities.WeaponItemDTO
import com.google.gson.annotations.SerializedName

data class WeaponsResponse(

    @field:SerializedName("data")
	val data: List<WeaponsDataItem>? = null,

    @field:SerializedName("status")
	val status: Int? = null
)

data class AirBurstStats(

	@field:SerializedName("shotgunPelletCount")
	val shotgunPelletCount: Int? = null,

	@field:SerializedName("burstDistance")
	val burstDistance: Any? = null
)
@Entity
data class WeaponsDataItem(

	@field:SerializedName("skins")
	val skins: List<SkinsItem?>? = null,

	@field:SerializedName("displayIcon")
	val displayIcon: String? = null,

	@field:SerializedName("killStreamIcon")
	val killStreamIcon: String? = null,

	@field:SerializedName("shopData")
	val shopData: ShopData? = null,

	@field:SerializedName("defaultSkinUuid")
	val defaultSkinUuid: String? = null,

	@field:SerializedName("displayName")
	val displayName: String? = null,

	@field:SerializedName("assetPath")
	val assetPath: String? = null,

	@field:SerializedName("weaponStats")
	val weaponStats: WeaponStats? = null,

	@field:SerializedName("category")
	val category: String? = null,

	@PrimaryKey
	@field:SerializedName("uuid")
	val uuid: String
)

data class DamageRangesItem(

	@field:SerializedName("rangeEndMeters")
	val rangeEndMeters: Int? = null,

	@field:SerializedName("headDamage")
	val headDamage: Float? = null,

	@field:SerializedName("bodyDamage")
	val bodyDamage: Int? = null,

	@field:SerializedName("legDamage")
	val legDamage: Any? = null,

	@field:SerializedName("rangeStartMeters")
	val rangeStartMeters: Int? = null
)

data class WeaponStats(

	@field:SerializedName("damageRanges")
	val damageRanges: List<DamageRangesItem?>? = null,

	@field:SerializedName("equipTimeSeconds")
	val equipTimeSeconds: Any? = null,

	@field:SerializedName("shotgunPelletCount")
	val shotgunPelletCount: Int? = null,

	@field:SerializedName("adsStats")
	val adsStats: AdsStats? = null,

	@field:SerializedName("fireRate")
	val fireRate: Float? = null,

	@field:SerializedName("runSpeedMultiplier")
	val runSpeedMultiplier: Any? = null,

	@field:SerializedName("feature")
	val feature: String? = null,

	@field:SerializedName("airBurstStats")
	val airBurstStats: Any? = null,

	@field:SerializedName("reloadTimeSeconds")
	val reloadTimeSeconds: Float? = null,

	@field:SerializedName("wallPenetration")
	val wallPenetration: String? = null,

	@field:SerializedName("magazineSize")
	val magazineSize: Int? = null,

	@field:SerializedName("fireMode")
	val fireMode: Any? = null,

	@field:SerializedName("firstBulletAccuracy")
	val firstBulletAccuracy: Any? = null,

	@field:SerializedName("altFireType")
	val altFireType: String? = null,

	@field:SerializedName("altShotgunStats")
	val altShotgunStats: Any? = null
)

data class ShopData(

	@field:SerializedName("canBeTrashed")
	val canBeTrashed: Boolean? = null,

	@field:SerializedName("image")
	val image: Any? = null,

	@field:SerializedName("cost")
	val cost: Int? = null,

	@field:SerializedName("newImage")
	val newImage: String? = null,

	@field:SerializedName("newImage2")
	val newImage2: Any? = null,

	@field:SerializedName("assetPath")
	val assetPath: String? = null,

	@field:SerializedName("gridPosition")
	val gridPosition: GridPosition? = null,

	@field:SerializedName("category")
	val category: String? = null,

	@field:SerializedName("categoryText")
	val categoryText: String? = null
)

data class ChromasItem(

	@field:SerializedName("displayIcon")
	val displayIcon: Any? = null,

	@field:SerializedName("swatch")
	val swatch: Any? = null,

	@field:SerializedName("displayName")
	val displayName: String? = null,

	@field:SerializedName("assetPath")
	val assetPath: String? = null,

	@field:SerializedName("fullRender")
	val fullRender: String? = null,

	@field:SerializedName("uuid")
	val uuid: String? = null,

	@field:SerializedName("streamedVideo")
	val streamedVideo: Any? = null
)

data class GridPosition(

	@field:SerializedName("column")
	val column: Int? = null,

	@field:SerializedName("row")
	val row: Int? = null
)

data class SkinsItem(

	@field:SerializedName("displayIcon")
	val displayIcon: String? = null,

	@field:SerializedName("contentTierUuid")
	val contentTierUuid: String? = null,

	@field:SerializedName("wallpaper")
	val wallpaper: Any? = null,

	@field:SerializedName("displayName")
	val displayName: String? = null,

	@field:SerializedName("assetPath")
	val assetPath: String? = null,

	@field:SerializedName("chromas")
	val chromas: List<ChromasItem?>? = null,

	@field:SerializedName("uuid")
	val uuid: String? = null,

	@field:SerializedName("themeUuid")
	val themeUuid: String? = null,

	@field:SerializedName("levels")
	val levels: List<LevelsItem?>? = null
)

data class AdsStats(

	@field:SerializedName("fireRate")
	val fireRate: Any? = null,

	@field:SerializedName("burstCount")
	val burstCount: Int? = null,

	@field:SerializedName("runSpeedMultiplier")
	val runSpeedMultiplier: Any? = null,

	@field:SerializedName("zoomMultiplier")
	val zoomMultiplier: Any? = null,

	@field:SerializedName("firstBulletAccuracy")
	val firstBulletAccuracy: Any? = null
)

data class LevelsItem(

	@field:SerializedName("displayIcon")
	val displayIcon: String? = null,

	@field:SerializedName("levelItem")
	val levelItem: Any? = null,

	@field:SerializedName("displayName")
	val displayName: String? = null,

	@field:SerializedName("assetPath")
	val assetPath: String? = null,

	@field:SerializedName("uuid")
	val uuid: String? = null,

	@field:SerializedName("streamedVideo")
	val streamedVideo: Any? = null
)

data class AltShotgunStats(

	@field:SerializedName("shotgunPelletCount")
	val shotgunPelletCount: Int? = null,

	@field:SerializedName("burstRate")
	val burstRate: Any? = null
)

fun WeaponsDataItem.toWeaponItemDTO() : WeaponItemDTO {

	return WeaponItemDTO(
		displayIcon = displayIcon,
		displayName = displayName
		)

}
