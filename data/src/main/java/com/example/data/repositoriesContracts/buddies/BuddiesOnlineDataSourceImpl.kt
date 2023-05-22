package com.example.data.repositoriesContracts.buddies

import com.example.data.database.ValorantDatabase
import com.example.data.model.toBuddyItemDTO
import com.example.data.repositoriesContracts.WebServices
import com.example.domain.entities.BuddyItemDTO
import com.example.domain.entities.Resource
import com.example.domain.repository.BuddiesOnlineDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class BuddiesOnlineDataSourceImpl @Inject constructor(val webServices: WebServices,
val valorantDatabase: ValorantDatabase) : BuddiesOnlineDataSource {
    override suspend fun getBuddies(): Flow<Resource<List<BuddyItemDTO>>> {

       val response =  webServices.getBuddies()

        response.data?.let { valorantDatabase.getBuddiesDao().saveBuddies(it) }

        return flow<Resource<List<BuddyItemDTO>>>{

            val successfulResponse = Resource.Success(response.data?.map {

                it.toBuddyItemDTO()
            }!!)

            emit(successfulResponse)

        }.onStart {
            emit(Resource.Loading())
        }.catch {

            emit(Resource.Error(it.message ?: "error"))
        }


        }
    }
