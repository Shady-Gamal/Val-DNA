package com.example.data.database.DataBaseDAO

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.BundlesDataItem

@Dao
interface BundlesDao {

    @Query("SELECT * FROM BundlesDataItem")
   suspend fun getBundles(): List<BundlesDataItem>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveBundles(bundles: List<BundlesDataItem>)


    @Query("DELETE FROM BundlesDataItem")
    suspend fun clearAll()
}