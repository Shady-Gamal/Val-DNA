package com.example.data.repositoriesContracts.agents

import android.util.Log
import com.example.data.database.ValorantDatabase
import com.example.data.model.AgentsDataItem
import com.example.data.model.toAgentItemDTO
import com.example.data.util.toDomainobject
import com.example.domain.entities.AgentItemDTO
import com.example.domain.entities.Resource
import com.example.domain.repository.AgentsOfflineDataSource
import kotlinx.coroutines.flow.*
import java.util.UUID
import javax.inject.Inject

class AgentsOfflineDataSourceImpl @Inject constructor(val valorantDatabase: ValorantDatabase) : AgentsOfflineDataSource {
    override suspend fun getAgents(): Flow<Resource<List<AgentItemDTO>>> {

        return flow<Resource<List<AgentItemDTO>>> {

            emit( Resource.Success(valorantDatabase.getAgentsDao().getAgents().map {
                it.toAgentItemDTO()
            }
            ))
        }.onStart {
            emit(Resource.Loading())
        }.catch {

            emit(Resource.Error(it.message ?: "error"))
        }
    }

    override suspend fun getAgentByUUID(uuid: String): Flow<Resource<AgentItemDTO>> {
        val response = valorantDatabase.getAgentsDao().getSelectedAgent(uuid)
        return flow<Resource<AgentItemDTO>> {
            val successfulResponse = Resource.Success(response.toAgentItemDTO())
            emit(successfulResponse)

        }.onStart {

            emit(Resource.Loading())
        }.catch {

            emit(Resource.Error(it.message ?: "Error") )
        }
    }


}