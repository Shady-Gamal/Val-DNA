package com.example.data.repositoriesContracts.maps

import android.content.Context
import com.example.data.util.isOnline
import com.example.domain.entities.MapItemDTO
import com.example.domain.entities.Resource
import com.example.domain.repository.MapsOfflineDataSource
import com.example.domain.repository.MapsOnlineDataSource
import com.example.domain.repository.MapsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MapsRepositoryImpl @Inject constructor(val mapsOnlineDataSource: MapsOnlineDataSource,
val mapsOfflineDataSource: MapsOfflineDataSource,
val context: Context) : MapsRepository {
    override suspend fun getMaps(): Flow<Resource<List<MapItemDTO>>> {
        if (isOnline(context)){
            mapsOnlineDataSource.getMaps()
            return mapsOfflineDataSource.getMaps()

        }else{
            return mapsOfflineDataSource.getMaps()

        }
    }
}