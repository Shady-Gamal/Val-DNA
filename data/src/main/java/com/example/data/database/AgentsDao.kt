package com.example.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.AgentsDataItem
import com.example.domain.entities.Resource
import kotlinx.coroutines.flow.Flow


@Dao
interface AgentsDao {

    @Query("select * from AgentsDataItem")
 suspend fun getAgents() : List<AgentsDataItem>

 @Insert(onConflict = OnConflictStrategy.REPLACE)
 suspend fun saveAgents(Agents : List<AgentsDataItem>)

    @Query("SELECT (SELECT COUNT(*) FROM AgentsDataItem) == 0")
   suspend fun isEmpty(): Boolean

   @Query("Select * from AgentsDataITem Where uuid = :agentUUID ")
   suspend fun getSelectedAgent(agentUUID : String) : AgentsDataItem



}