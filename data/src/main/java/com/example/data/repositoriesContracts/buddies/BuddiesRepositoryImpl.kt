package com.example.data.repositoriesContracts.buddies

import android.content.Context
import com.example.data.util.isOnline
import com.example.domain.entities.BuddyItemDTO
import com.example.domain.entities.Resource
import com.example.domain.repository.BuddiesOfflineDataSource
import com.example.domain.repository.BuddiesOnlineDataSource
import com.example.domain.repository.BuddiesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BuddiesRepositoryImpl @Inject constructor(
    val buddiesOnlineDataSource: BuddiesOnlineDataSource,
    val buddiesOfflineDataSource: BuddiesOfflineDataSource,
    val context: Context
) : BuddiesRepository {
    override suspend fun getBuddies(): Flow<Resource<List<BuddyItemDTO>>> {

        if (isOnline(context)){
            buddiesOnlineDataSource.getBuddies()
            return buddiesOfflineDataSource.getBuddies()

        }else{
            return buddiesOfflineDataSource.getBuddies()

        }
    }
}