package com.example.domain.usecases

import com.example.domain.entities.BuddyItemDTO
import com.example.domain.entities.Resource
import com.example.domain.repository.BuddiesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBuddiesUseCase @Inject constructor(val buddiesRepository: BuddiesRepository) {

    suspend operator fun invoke() : Flow<Resource<List<BuddyItemDTO>>>{


        return buddiesRepository.getBuddies()
    }
}