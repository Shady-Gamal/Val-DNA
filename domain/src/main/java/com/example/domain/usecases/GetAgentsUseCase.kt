package com.example.domain.usecases

import com.example.domain.entities.AgentItemDTO
import com.example.domain.entities.Resource
import com.example.domain.repository.AgentsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAgentsUseCase @Inject constructor(val agentsRepository : AgentsRepository) {

    suspend operator fun invoke() : Flow<Resource<List<AgentItemDTO>>>{

        return agentsRepository.getAgents()
    }
}