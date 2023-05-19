package com.example.data.repositoriesContracts.agents

import com.example.data.database.ValorantDatabase
import com.example.data.model.toAgentItemDTO
import com.example.data.repositoriesContracts.WebServices
import com.example.domain.entities.AgentItemDTO
import com.example.domain.entities.Resource
import com.example.domain.repository.AgentsOnlineDataSource
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class AgentsOnlineDataSourceImpl @Inject constructor(val webServices: WebServices,
val valorantDatabase: ValorantDatabase) : AgentsOnlineDataSource {
    override suspend fun getAgents(): Flow<Resource<List<AgentItemDTO>>> {

        val response = webServices.getAgents()

        response.data?.let { valorantDatabase.getAgentsDao().saveAgents(it) }

        return flow<Resource<List<AgentItemDTO>>> {

            val successfulResponse = Resource.Success(response.data?.map {
                it.toAgentItemDTO()
            }!!)
            emit(successfulResponse)
        }.onStart {
            emit(Resource.Loading())
        }.catch {

            emit(Resource.Error(it.message?: "Something went wrong"))
        }
    }
}