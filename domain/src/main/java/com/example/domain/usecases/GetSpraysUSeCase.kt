package com.example.domain.usecases

import com.example.domain.entities.Resource
import com.example.domain.entities.SprayItemDTO
import com.example.domain.repository.SpraysRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSpraysUSeCase @Inject constructor(val spraysRepository: SpraysRepository) {
    suspend operator fun invoke() : Flow<Resource<List<SprayItemDTO>>> {

        return spraysRepository.getSprays()
    }
}