package com.example.domain.repository

import android.content.res.Resources
import com.example.domain.entities.AgentItemDTO
import com.example.domain.entities.Resource
import kotlinx.coroutines.flow.Flow


interface AgentsRepository {

        suspend fun getAgents() : Flow<Resource<List<AgentItemDTO>>>
        suspend fun getAgentByUUID(uuid : String) : Flow<Resource<AgentItemDTO>>
}
interface AgentsOnlineDataSource{

        suspend fun getAgents()

}
interface AgentsOfflineDataSource{

        suspend fun getAgents() : Flow<Resource<List<AgentItemDTO>>>
        suspend fun getAgentByUUID(uuid : String) : Flow<Resource<AgentItemDTO>>

}