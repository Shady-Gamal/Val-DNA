package com.example.valorant.domain.usecases

import com.example.domain.entities.AgentItemDTO
import com.example.domain.usecases.GetAgentsUseCase
import com.example.domain.data.repository.FakeAgentsRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GetAUseCaseTest{

    private lateinit var getAgentsUseCase: GetAgentsUseCase
    private lateinit var fakeAgentsRepository: com.example.domain.data.repository.FakeAgentsRepository
    @Before
    fun setUp(){
fakeAgentsRepository = com.example.domain.data.repository.FakeAgentsRepository()
        getAgentsUseCase = GetAgentsUseCase(fakeAgentsRepository)

        val agentsForTesting = mutableListOf<AgentItemDTO>()

        agentsForTesting.add(
            AgentItemDTO(displayName = "Omen")
        )
        agentsForTesting.add(
            AgentItemDTO(displayName = "Gekko")
        )
        agentsForTesting.add(
            AgentItemDTO(displayName = "Killjoy")
        )



    }
    @Test
    fun `testshit`() = runBlocking{

        val agents = getAgentsUseCase()

        assertTrue(agents)
    }
}