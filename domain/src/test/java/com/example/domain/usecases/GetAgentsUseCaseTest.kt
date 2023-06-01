package com.example.domain.usecases

import com.example.domain.data.repository.FakeAgentsRepository
import com.example.domain.entities.AgentItemDTO
import com.example.domain.entities.Resource
import junit.framework.Assert.*
import kotlinx.coroutines.runBlocking


import org.junit.After
import org.junit.Before
import org.junit.Test


class GetAgentsUseCaseTest {

    private lateinit var getAgentsUseCase: GetAgentsUseCase
    private lateinit var fakeAgentsRepository: FakeAgentsRepository

    @Before
    fun setUp() {

        fakeAgentsRepository = FakeAgentsRepository()
        getAgentsUseCase = GetAgentsUseCase(fakeAgentsRepository)



    }

    @Test
     fun `testshit`() = runBlocking {
        var agentsForTesting = mutableListOf<AgentItemDTO>()

        agentsForTesting.add(
            AgentItemDTO(displayName = "Omen")
        )
        agentsForTesting.add(
            AgentItemDTO(displayName = "Gekko")
        )
        agentsForTesting.add(
            AgentItemDTO(displayName = "Killjoy")
        )

        val agentsFromUseCase = mutableListOf<AgentItemDTO>()
            getAgentsUseCase.invoke().collect{
                when(it){

                is Resource.Success -> {
                   it.data?.forEach {
                       agentsFromUseCase.add(it)
                   }
                }
                else -> {}
            }
        }

        assertEquals(agentsForTesting.get(0).displayName,agentsFromUseCase.get(0).displayName)

    }
}