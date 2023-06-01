package com.example.domain.data.repository

import com.example.domain.entities.AgentItemDTO
import com.example.domain.entities.Resource
import com.example.domain.repository.AgentsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeAgentsRepository() : AgentsRepository {

    private val agents = mutableListOf<AgentItemDTO>(

            AgentItemDTO(displayName = "Omen"),

                AgentItemDTO(displayName = "Gekko"),


                AgentItemDTO(displayName = "Killjoy")

    )


    override suspend fun getAgents(): Flow<Resource<List<AgentItemDTO>>> {
        return flow { emit(Resource.Success(agents)) }
    }

    override suspend fun getAgentByUUID(uuid: String): Flow<Resource<AgentItemDTO>> {

        return flow {
            emit(Resource.Success(agents.find { it.uuid == uuid }!!))
        }
    }
}