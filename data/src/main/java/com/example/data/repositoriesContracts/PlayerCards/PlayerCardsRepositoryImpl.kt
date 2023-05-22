package com.example.data.repositoriesContracts.PlayerCards

import android.content.Context
import com.example.data.util.isOnline
import com.example.domain.entities.PlayerCardItemDTO
import com.example.domain.entities.Resource
import com.example.domain.repository.PlayerCardsOfflineDataSource
import com.example.domain.repository.PlayerCardsOnlineDataSource
import com.example.domain.repository.PlayerCardsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PlayerCardsRepositoryImpl @Inject constructor(
  val  playerCardsOnlineDataSource: PlayerCardsOnlineDataSource,
  val playerCardsOfflineDataSource: PlayerCardsOfflineDataSource,
  val context: Context
) : PlayerCardsRepository {
    override suspend fun getPlayerCards(): Flow<Resource<List<PlayerCardItemDTO>>> {

        if (isOnline(context)){
            playerCardsOnlineDataSource.getPlayerCards()
            return playerCardsOfflineDataSource.getPlayerCards()

        }else{
            return playerCardsOfflineDataSource.getPlayerCards()

        }
    }

}