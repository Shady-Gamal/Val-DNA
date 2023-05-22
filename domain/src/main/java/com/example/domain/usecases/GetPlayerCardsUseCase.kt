package com.example.domain.usecases

import com.example.domain.entities.PlayerCardItemDTO
import com.example.domain.entities.Resource
import com.example.domain.repository.PlayerCardsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPlayerCardsUseCase @Inject constructor(val playerCardsRepository: PlayerCardsRepository) {

    suspend operator fun invoke() : Flow<Resource<List<PlayerCardItemDTO>>> {
        return playerCardsRepository.getPlayerCards()
    }
}