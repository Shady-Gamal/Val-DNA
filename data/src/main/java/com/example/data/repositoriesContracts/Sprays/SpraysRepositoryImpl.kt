package com.example.data.repositoriesContracts.Sprays

import android.content.Context
import com.example.data.util.isOnline
import com.example.domain.entities.Resource
import com.example.domain.entities.SprayItemDTO
import com.example.domain.repository.SpraysOfflineDataSource
import com.example.domain.repository.SpraysOnlineDataSource
import com.example.domain.repository.SpraysRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SpraysRepositoryImpl @Inject constructor(val spraysOnlineDataSource: SpraysOnlineDataSource,
val spraysOfflineDataSource: SpraysOfflineDataSource,
val context: Context) : SpraysRepository {
    override suspend fun getSprays(): Flow<Resource<List<SprayItemDTO>>> {

        if (isOnline(context)){

            spraysOnlineDataSource.getSprays()
            return spraysOfflineDataSource.getSprays()

        }else{
            return spraysOnlineDataSource.getSprays()

        }
    }
}