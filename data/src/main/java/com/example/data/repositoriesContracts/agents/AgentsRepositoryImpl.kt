package com.example.data.repositoriesContracts.agents

import android.content.Context
import com.example.data.database.ValorantDatabase

import com.example.data.util.isOnline
import com.example.domain.entities.AgentItemDTO
import com.example.domain.entities.Resource
import com.example.domain.repository.AgentsOfflineDataSource
import com.example.domain.repository.AgentsOnlineDataSource
import com.example.domain.repository.AgentsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AgentsRepositoryImpl @Inject constructor(val agentsOnlineDataSource: AgentsOnlineDataSource
, val agentsOfflineDataSource: AgentsOfflineDataSource,
val context : Context) : AgentsRepository {
    override suspend fun getAgents(): Flow<Resource<List<AgentItemDTO>>> {


       if (isOnline(context)){

           agentsOnlineDataSource.getAgents()
           return agentsOfflineDataSource.getAgents()

       }else{
           return agentsOfflineDataSource.getAgents()

        }

    }

    override suspend fun getAgentByUUID(uuid: String): Flow<Resource<AgentItemDTO>> {

        return agentsOfflineDataSource.getAgentByUUID(uuid)
    }
}