package com.example.domain.repository

import com.example.domain.entities.BuddyItemDTO
import com.example.domain.entities.Resource
import kotlinx.coroutines.flow.Flow

interface BuddiesRepository {

    suspend fun getBuddies() : Flow<Resource<List<BuddyItemDTO>>>

}
interface BuddiesOnlineDataSource{

     suspend fun getBuddies()

}

interface BuddiesOfflineDataSource{

     fun getBuddies() : Flow<Resource<List<BuddyItemDTO>>>


}