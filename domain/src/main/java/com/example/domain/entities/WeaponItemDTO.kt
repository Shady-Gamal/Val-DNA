package com.example.domain.entities

data class WeaponItemDTO(

    val skins: List<WeaponSkinsItemDTO?>? = null,

    val displayIcon: String? = null,

    val killStreamIcon: String? = null,

    val shopData: ShopDataDTO? = null,

    val defaultSkinUuid: String? = null,


    val displayName: String? = null,


    val assetPath: String? = null,


    val weaponStats: WeaponStatsDTO? = null,


    val category: String? = null,


    val uuid: String? = null
)

data class DamageRangesItemDTO(


    val rangeEndMeters: Int? = null,

    val headDamage: Float? = null,

    val bodyDamage: Int? = null,


    val legDamage: Any? = null,


    val rangeStartMeters: Int? = null
)

data class WeaponStatsDTO(


    val damageRanges: List<DamageRangesItemDTO?>? = null,


    val equipTimeSeconds: Any? = null,


    val shotgunPelletCount: Int? = null,


    val adsStats: AdsStatsDTO? = null,


    val fireRate: Float? = null,


    val runSpeedMultiplier: Any? = null,


    val feature: String? = null,


    val airBurstStats: Any? = null,


    val reloadTimeSeconds: Float? = null,


    val wallPenetration: String? = null,


    val magazineSize: Int? = null,


    val fireMode: Any? = null,


    val firstBulletAccuracy: Any? = null,


    val altFireType: String? = null,


    val altShotgunStats: Any? = null
)

data class ShopDataDTO(


    val canBeTrashed: Boolean? = null,


    val image: Any? = null,


    val cost: Int? = null,


    val newImage: String? = null,


    val newImage2: Any? = null,


    val assetPath: String? = null,


    val gridPosition: GridPositionDTO? = null,


    val category: String? = null,


    val categoryText: String? = null
)

data class ChromasItemDTO(


    val displayIcon: Any? = null,


    val swatch: Any? = null,


    val displayName: String? = null,


    val assetPath: String? = null,


    val fullRender: String? = null,


    val uuid: String? = null,


    val streamedVideo: Any? = null
)

data class GridPositionDTO(


    val column: Int? = null,


    val row: Int? = null
)

data class WeaponSkinsItemDTO(


    val displayIcon: String? = null,


    val contentTierUuid: String? = null,


    val wallpaper: Any? = null,


    val displayName: String? = null,


    val assetPath: String? = null,


    val chromas: List<ChromasItemDTO?>? = null,


    val uuid: String? = null,


    val themeUuid: String? = null,


    val levels: List<WeaponsLevelsItemDTO?>? = null
)

data class AdsStatsDTO(


    val fireRate: Any? = null,


    val burstCount: Int? = null,


    val runSpeedMultiplier: Any? = null,


    val zoomMultiplier: Any? = null,


    val firstBulletAccuracy: Any? = null
)

data class WeaponsLevelsItemDTO(


    val displayIcon: String? = null,


    val levelItem: Any? = null,


    val displayName: String? = null,


    val assetPath: String? = null,


    val uuid: String? = null,


    val streamedVideo: Any? = null
)

data class AltShotgunStatsDTO(


    val shotgunPelletCount: Int? = null,


    val burstRate: Any? = null
)

