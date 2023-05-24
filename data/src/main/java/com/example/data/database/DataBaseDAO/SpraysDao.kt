package com.example.data.database.DataBaseDAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.MapsDataItem
import com.example.data.model.SpraysDataItem

@Dao
interface SpraysDao {

    @Query("SELECT * FROM SpraysDataItem")
    suspend fun getSprays(): List<SpraysDataItem>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveSprays(sprays: List<SpraysDataItem>)
}