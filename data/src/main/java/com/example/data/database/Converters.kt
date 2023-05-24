package com.example.data.database

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.data.model.*
import com.example.data.util.JsonParser
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters(val jsonParser: JsonParser) {

    @TypeConverter
    fun fromRole(json: String) : Role{
        return jsonParser.fromJson<Role>(
            json = json,
            object : TypeToken<Role>(){}.type
        ) ?: Role()
    }
    @TypeConverter
    fun toRole(roles :Role?) : String{
        return jsonParser.toJson(
            roles,
            object : TypeToken<Role>(){}.type
        )?: "[]"
    }


    @TypeConverter
    fun frombackgroundGradientColorsJson(json: String): List<String> {
        return jsonParser.fromJson<ArrayList<String>>(
            json,
            object : TypeToken<ArrayList<String>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun tobackgroundGradientColorsJson(meanings: List<String>?): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<ArrayList<String>>(){}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromAbilitiesItemJson(json: String): List<AbilitiesItem> {
        return jsonParser.fromJson<ArrayList<AbilitiesItem>>(
            json,
            object : TypeToken<ArrayList<AbilitiesItem>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toAbilitiesItemJson(meanings: List<AbilitiesItem>): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<ArrayList<AbilitiesItem>>(){}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromVoiceLineJson(json: String): VoiceLine {
        return jsonParser.fromJson<VoiceLine>(
            json,
            object : TypeToken<VoiceLine>(){}.type
        ) ?: VoiceLine()
    }

    @TypeConverter
    fun toVoiceLineJson(meanings: VoiceLine): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<VoiceLine>(){}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromSkinsItemJson(json: String): List<WeaponsSkinsItem> {
        return jsonParser.fromJson<ArrayList<WeaponsSkinsItem>>(
            json,
            object : TypeToken<ArrayList<WeaponsSkinsItem>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toSkinsItemJson(meanings: List<WeaponsSkinsItem>?): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<ArrayList<WeaponsSkinsItem>>(){}.type
        ) ?: "[]"
    }


    @TypeConverter
    fun fromShopDataJson(json: String): ShopData {
        return jsonParser.fromJson<ShopData>(
            json,
            object : TypeToken<ShopData>(){}.type
        ) ?: ShopData()
    }

    @TypeConverter
    fun toShopDataJson(meanings: ShopData?): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<ShopData>(){}.type
        ) ?: "[]"
    }


    @TypeConverter
    fun fromWeaponStatsJson(json: String): WeaponStats {
        return jsonParser.fromJson<WeaponStats>(
            json,
            object : TypeToken<WeaponStats>(){}.type
        ) ?: WeaponStats()
    }

    @TypeConverter
    fun toWeaponStatsJson(meanings: WeaponStats?): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<WeaponStats>(){}.type
        ) ?: "[]"
    }
    @TypeConverter
    fun fromBuddiesLevelItemJson(json: String): List<BuddiesLevelsItem> {
        return jsonParser.fromJson<ArrayList<BuddiesLevelsItem>>(
            json,
            object : TypeToken<ArrayList<BuddiesLevelsItem>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toBuddiesLevelItemJson(meanings: List<BuddiesLevelsItem>?): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<ArrayList<BuddiesLevelsItem>>(){}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromCalloutsItemJson(json: String): List<CalloutsItem> {
        return jsonParser.fromJson<ArrayList<CalloutsItem>>(
            json,
            object : TypeToken<ArrayList<CalloutsItem>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toCalloutsItemJson(meanings: List<CalloutsItem>?): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<ArrayList<CalloutsItem>>(){}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromSpraysLevelItemJson(json: String): List<SpraysLevelsItem> {
        return jsonParser.fromJson<ArrayList<SpraysLevelsItem>>(
            json,
            object : TypeToken<ArrayList<SpraysLevelsItem>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toCSpraysLevelItemJson(meanings: List<SpraysLevelsItem>?): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<ArrayList<SpraysLevelsItem>>(){}.type
        ) ?: "[]"
    }


}