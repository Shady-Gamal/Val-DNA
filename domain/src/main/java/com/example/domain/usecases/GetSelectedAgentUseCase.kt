package com.example.domain.usecases

import com.example.domain.entities.AgentItemDTO
import com.example.domain.entities.Resource
import com.example.domain.repository.AgentsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSelectedAgentUseCase @Inject constructor(val agentsRepository: AgentsRepository) {

    suspend operator fun invoke(uuid : String) : Flow<Resource<AgentItemDTO>>{

return agentsRepository.getAgentByUUID(uuid)

    }
}