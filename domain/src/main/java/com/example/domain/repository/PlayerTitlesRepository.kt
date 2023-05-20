package com.example.domain.repository

import com.example.domain.entities.BundleItemDTO
import com.example.domain.entities.PlayerTitleDTO
import com.example.domain.entities.Resource
import kotlinx.coroutines.flow.Flow

interface PlayerTitlesRepository {

    suspend fun getPlayerTitles() : Flow<Resource<List<PlayerTitleDTO>>>

}
interface PlayerTitlesOnlineDataSource{

    suspend fun getPlayerTitles() : Flow<Resource<List<PlayerTitleDTO>>>

}

interface PlayerTitlesOfflineDataSource{

    suspend fun getPlayerTitles() : Flow<Resource<List<PlayerTitleDTO>>>


}