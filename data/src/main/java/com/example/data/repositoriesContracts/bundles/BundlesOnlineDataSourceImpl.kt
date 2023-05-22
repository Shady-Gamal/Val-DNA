package com.example.data.repositoriesContracts.bundles

import com.example.data.database.ValorantDatabase
import com.example.data.model.toBundleItemDTO
import com.example.data.repositoriesContracts.WebServices
import com.example.domain.entities.BundleItemDTO
import com.example.domain.entities.Resource
import com.example.domain.repository.BundlesOnlineDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class BundlesOnlineDataSourceImpl @Inject constructor(val webServices: WebServices,
val valorantDatabase: ValorantDatabase) :
    BundlesOnlineDataSource {
    override suspend fun getBundles(): Flow<Resource<List<BundleItemDTO>>> {
        val response = webServices.getBundles()

        response.data?.let { valorantDatabase.getBundlesDao().saveBundles(it) }


        return flow<Resource<List<BundleItemDTO>>>{
            val successfulResponse = Resource.Success(response.data?.map {
                it.toBundleItemDTO()
            }!!)
            emit(successfulResponse)
        }.onStart {
            emit(Resource.Loading())
        }.catch {
            emit(Resource.Error(it.message ?: "an error has occured"))

        } }
}