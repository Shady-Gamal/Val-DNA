package com.example.data.database.DataBaseDAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.BundlesDataItem
import com.example.data.model.MapsDataItem

@Dao
interface MapsDao {

    @Query("SELECT * FROM MapsDataItem")
    suspend fun getMaps(): List<MapsDataItem>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMaps(Maps: List<MapsDataItem>)
}