package com.example.data.repositoriesContracts.maps

import com.example.data.database.ValorantDatabase
import com.example.data.model.toMapItemDTO
import com.example.domain.entities.MapItemDTO
import com.example.domain.entities.Resource
import com.example.domain.repository.MapsOfflineDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class MapsOfflineDataSourceImpl @Inject constructor(val valorantDatabase: ValorantDatabase) : MapsOfflineDataSource {
    override suspend fun getMaps(): Flow<Resource<List<MapItemDTO>>> {

        val response = valorantDatabase.getMapsDao().getMaps()

        return flow<Resource<List<MapItemDTO>>>{

            val successfulResponse = Resource.Success(response.map {
                it.toMapItemDTO()
            })

            emit(successfulResponse)
        }.onStart {
            emit(Resource.Loading())
        }.catch {
            emit(Resource.Error(it.message ?: "error"))
        }
    }
}