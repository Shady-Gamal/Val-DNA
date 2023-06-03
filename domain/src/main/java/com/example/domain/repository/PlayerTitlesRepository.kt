package com.example.domain.repository

import com.example.domain.entities.PlayerTitleIemDTO
import com.example.domain.entities.Resource
import kotlinx.coroutines.flow.Flow

interface PlayerTitlesRepository {

    suspend fun getPlayerTitles() : Flow<Resource<List<PlayerTitleIemDTO>>>

}
interface PlayerTitlesOnlineDataSource{

    suspend fun getPlayerTitles()

}

interface PlayerTitlesOfflineDataSource{

    suspend fun getPlayerTitles() : Flow<Resource<List<PlayerTitleIemDTO>>>


}