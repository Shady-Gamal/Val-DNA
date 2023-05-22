package com.example.data.database.DataBaseDAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.BundlesDataItem
import com.example.data.model.PlayerCardsDataItem

@Dao
interface PlayerCardsDao {

    @Query("SELECT * FROM PlayerCardsDataItem")
    suspend fun getPlayerCards() : List<PlayerCardsDataItem>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePlayerCards(playerCardItem: List<PlayerCardsDataItem>)
}