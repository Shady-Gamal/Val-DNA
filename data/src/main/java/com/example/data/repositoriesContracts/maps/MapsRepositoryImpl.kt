package com.example.data.repositoriesContracts.maps

import com.example.domain.entities.MapItemDTO
import com.example.domain.entities.Resource
import com.example.domain.repository.MapsOnlineDataSource
import com.example.domain.repository.MapsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MapsRepositoryImpl @Inject constructor(val mapsOnlineDataSource: MapsOnlineDataSource) : MapsRepository {
    override suspend fun getMaps(): Flow<Resource<List<MapItemDTO>>> {
       return mapsOnlineDataSource.getMaps()
    }
}