package com.example.data.repositoriesContracts.PlayerCards

import com.example.data.database.ValorantDatabase
import com.example.data.model.toPlayerCardItemDTO
import com.example.data.repositoriesContracts.WebServices
import com.example.domain.entities.PlayerCardItemDTO
import com.example.domain.entities.Resource
import com.example.domain.repository.PlayerCardsOnlineDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class PlayerCardsOnlineDataSourceImpl @Inject constructor(val webServices: WebServices,
val valorantDatabase: ValorantDatabase) : PlayerCardsOnlineDataSource {
    override suspend fun getPlayerCards(): Flow<Resource<List<PlayerCardItemDTO>>> {


        val response = webServices.getPlayerCards()

        response.data?.let { valorantDatabase.getPlayerCardsDao().savePlayerCards(it) }

        return flow<Resource<List<PlayerCardItemDTO>>> {
            val successfulResponse = Resource.Success(response.data?.map {
                it.toPlayerCardItemDTO()
            }!!)

            emit(successfulResponse)
        }.onStart {
            emit(Resource.Loading())
        }.catch {

            emit(Resource.Error(it.message ?: "Error"))
        }
    }

}