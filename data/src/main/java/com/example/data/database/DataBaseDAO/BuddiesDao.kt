package com.example.data.database.DataBaseDAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.BuddiesDataItem
import com.example.data.model.WeaponsDataItem

@Dao
interface BuddiesDao {

    @Query("select * from BuddiesDataItem")
    suspend fun getBuddies() : List<BuddiesDataItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveBuddies (buddies : List<BuddiesDataItem>)
}