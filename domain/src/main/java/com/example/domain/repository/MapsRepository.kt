package com.example.domain.repository

import com.example.domain.entities.MapItemDTO
import com.example.domain.entities.Resource
import kotlinx.coroutines.flow.Flow

interface MapsRepository {

    suspend fun getMaps() : Flow<Resource<List<MapItemDTO>>>
}
interface MapsOnlineDataSource{

    suspend fun getMaps()
}
interface MapsOfflineDataSource{

    suspend fun getMaps() : Flow<Resource<List<MapItemDTO>>>

}