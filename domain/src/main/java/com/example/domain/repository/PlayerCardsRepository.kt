package com.example.domain.repository

import com.example.domain.entities.BundleItemDTO
import com.example.domain.entities.PlayerCardItemDTO
import com.example.domain.entities.Resource
import kotlinx.coroutines.flow.Flow

interface PlayerCardsRepository {

    suspend fun getPlayerCards() : Flow<Resource<List<PlayerCardItemDTO>>>

}
interface PlayerCardsOnlineDataSource{

    suspend fun getPlayerCards()

}

interface PlayerCardsOfflineDataSource{

    suspend fun getPlayerCards() : Flow<Resource<List<PlayerCardItemDTO>>>


}