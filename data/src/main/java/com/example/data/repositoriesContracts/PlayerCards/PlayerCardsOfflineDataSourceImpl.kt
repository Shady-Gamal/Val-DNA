package com.example.data.repositoriesContracts.PlayerCards

import android.util.Log
import com.example.data.database.ValorantDatabase
import com.example.data.model.toPlayerCardItemDTO
import com.example.domain.entities.PlayerCardItemDTO
import com.example.domain.entities.Resource
import com.example.domain.repository.PlayerCardsOfflineDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class PlayerCardsOfflineDataSourceImpl @Inject constructor(
    val valorantDatabase: ValorantDatabase
) : PlayerCardsOfflineDataSource {
    override suspend fun getPlayerCards(): Flow<Resource<List<PlayerCardItemDTO>>> {

        return flow<Resource<List<PlayerCardItemDTO>>> {
            emit( Resource.Success(valorantDatabase.getPlayerCardsDao().getPlayerCards().map{
                it.toPlayerCardItemDTO()
            }
            ))
        }.onStart {
            emit(Resource.Loading())
        }.catch {
            Log.e("tag", it.message ?: "null" )
            emit(Resource.Error(it.message ?: "error"))
        }
    }
}