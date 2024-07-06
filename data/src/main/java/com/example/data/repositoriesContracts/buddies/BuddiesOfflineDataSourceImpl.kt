package com.example.data.repositoriesContracts.buddies

import com.example.data.database.ValorantDatabase
import com.example.data.model.toBuddyItemDTO
import com.example.domain.entities.BuddyItemDTO
import com.example.domain.entities.Resource
import com.example.domain.repository.BuddiesOfflineDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

import kotlinx.coroutines.flow.onStart
import javax.inject.Inject


class BuddiesOfflineDataSourceImpl @Inject constructor(val valorantDatabase: ValorantDatabase) : BuddiesOfflineDataSource {
    override fun getBuddies(): Flow<Resource<List<BuddyItemDTO>>> {

        return flow<Resource<List<BuddyItemDTO>>> {
            emit(
                Resource.Success(valorantDatabase.getBuddiesDao().getBuddies().map {
                    it.toBuddyItemDTO()
                })

            )
        }.onStart {
            emit(Resource.Loading())

        }.catch {

            emit(Resource.Error(it.message ?: "message"))

        }

    }

}