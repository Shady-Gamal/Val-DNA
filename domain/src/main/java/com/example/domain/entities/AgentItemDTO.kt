package com.example.domain.entities



data class AgentItemDTO(

    val killfeedPortrait: String? = null,

    val role: RoleDTO? = null,

    val isFullPortraitRightFacing: Boolean? = null,


    val displayName: String? = null,


    val isBaseContent: Boolean? = null,


    val description: String? = null,


    val backgroundGradientColors: List<String?>? = null,


    val isAvailableForTest: Boolean? = null,

    val uuid: String? = null,


    val characterTags: Any? = null,


    val displayIconSmall: String? = null,


    val fullPortrait: String? = null,


    val fullPortraitV2: String? = null,


    val abilities: List<AbilitiesItemDTO?>? = null,


    val displayIcon: String? = null,


    val bustPortrait: String? = null,


    val background: String? = null,


    val assetPath: String? = null,


    val voiceLine: VoiceLineDTO? = null,

    val isPlayableCharacter: Boolean? = null,

    val developerName: String? = null
)

data class RoleDTO(


    val displayIcon: String? = null,


    val displayName: String? = null,


    val assetPath: String? = null,


    val description: String? = null,


    val uuid: String? = null
)

data class AbilitiesItemDTO(


    val displayIcon: String? = null,


    val displayName: String? = null,


    val description: String? = null,


    val slot: String? = null
)
data class VoiceLineDTO(


    val minDuration: Any? = null,

    val mediaList: List<MediaListItemDTO?>? = null,

    val maxDuration: Any? = null
)
data class MediaListItemDTO(


    val id: Int? = null,


    val wave: String? = null,


    val wwise: String? = null
)






