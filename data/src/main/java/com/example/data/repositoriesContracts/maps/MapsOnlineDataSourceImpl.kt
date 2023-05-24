package com.example.data.repositoriesContracts.maps

import com.example.data.database.ValorantDatabase
import com.example.data.model.toMapItemDTO
import com.example.data.repositoriesContracts.WebServices
import com.example.domain.entities.MapItemDTO
import com.example.domain.entities.Resource
import com.example.domain.repository.MapsOnlineDataSource
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class MapsOnlineDataSourceImpl @Inject constructor(val webServices: WebServices,
val valorantDatabase: ValorantDatabase) :  MapsOnlineDataSource{
    override suspend fun getMaps(): Flow<Resource<List<MapItemDTO>>> {
        val response = webServices.getMaps()
        response.data?.let { valorantDatabase.getMapsDao().saveMaps(it) }
        return flow<Resource<List<MapItemDTO>>>{
            val successfulResponse = Resource.Success(response.data?.map {
                it.toMapItemDTO()
            }!!)
            emit(successfulResponse)

        }.onStart {
            emit(Resource.Loading())
        }.catch {
            emit(Resource.Error(it.message ?: "an error has occured"))

        } }
    }
