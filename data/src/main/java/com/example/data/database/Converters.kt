package com.example.data.database

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.data.model.AbilitiesItem
import com.example.data.model.Role
import com.example.data.model.VoiceLine
import com.example.data.util.JsonParser
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters(val jsonParser: JsonParser) {

    @TypeConverter
    fun fromRole(json: String) : Role{
        return jsonParser.fromJson<Role>(
            json = json,
            object : TypeToken<Role>(){}.type
        ) ?: Role("")
    }
    @TypeConverter
    fun toRole(roles :Role) : String{
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
        ) ?: VoiceLine("")
    }

    @TypeConverter
    fun toVoiceLineJson(meanings: VoiceLine): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<VoiceLine>(){}.type
        ) ?: "[]"
    }







}