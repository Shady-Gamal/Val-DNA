package com.example.data.repositoriesContracts.Sprays

import com.example.domain.entities.Resource
import com.example.domain.entities.SprayItemDTO
import com.example.domain.repository.SpraysOnlineDataSource
import com.example.domain.repository.SpraysRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SpraysRepositoryImpl @Inject constructor(val spraysOnlineDataSource: SpraysOnlineDataSource) : SpraysRepository {
    override suspend fun getSprays(): Flow<Resource<List<SprayItemDTO>>> {
        return spraysOnlineDataSource.getSprays()
    }
}