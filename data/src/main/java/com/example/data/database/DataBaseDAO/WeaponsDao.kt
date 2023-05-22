package com.example.data.database.DataBaseDAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.AgentsDataItem
import com.example.data.model.WeaponsDataItem

@Dao
interface WeaponsDao {


    @Query("select * from WeaponsDataItem")
    suspend fun getWeapons() : List<WeaponsDataItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveWeapons (weapons : List<WeaponsDataItem>)

    @Query("Select * from WeaponsDataItem Where uuid = :weaponUUID ")
    suspend fun getSelectedAgent(weaponUUID : String) : WeaponsDataItem
}