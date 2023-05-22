package com.example.domain.repository

import com.example.domain.entities.Resource
import com.example.domain.entities.SprayItemDTO
import kotlinx.coroutines.flow.Flow

interface SpraysRepository {

    suspend fun getSprays() : Flow<Resource<List<SprayItemDTO>>>

}
interface SpraysOnlineDataSource{

    suspend fun getSprays() : Flow<Resource<List<SprayItemDTO>>>

}

interface SpraysOfflineDataSource{

    suspend fun getSprays() : Flow<Resource<List<SprayItemDTO>>>


}