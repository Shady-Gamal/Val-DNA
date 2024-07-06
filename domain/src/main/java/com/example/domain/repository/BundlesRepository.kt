package com.example.domain.repository

import com.example.domain.entities.BundleItemDTO
import com.example.domain.entities.Resource
import kotlinx.coroutines.flow.Flow


interface BundlesRepository {

     suspend fun getBundles() : Flow<Resource<List<BundleItemDTO>>>

}
interface BundlesOnlineDataSource{

    suspend fun getBundles()

}

interface BundlesOfflineDataSource{

     fun getBundles() : Flow<Resource<List<BundleItemDTO>>>


}