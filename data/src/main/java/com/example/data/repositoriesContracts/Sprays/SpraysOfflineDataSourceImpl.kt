package com.example.data.repositoriesContracts.Sprays

import com.example.data.database.ValorantDatabase
import com.example.data.model.toSprayItemDTO
import com.example.domain.entities.Resource
import com.example.domain.entities.SprayItemDTO
import com.example.domain.repository.SpraysOfflineDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class SpraysOfflineDataSourceImpl @Inject constructor(val valorantDatabase: ValorantDatabase) : SpraysOfflineDataSource {
    override suspend fun getSprays(): Flow<Resource<List<SprayItemDTO>>> {

        val response = valorantDatabase.getSpraysDao().getSprays()

        return flow<Resource<List<SprayItemDTO>>> {
            val successfulResponse = Resource.Success(response.map {
                it.toSprayItemDTO()
            })
            emit(successfulResponse)
        }.onStart {
            emit(Resource.Loading())
        }.catch {
            emit(Resource.Loading())
        }

        }

    }
