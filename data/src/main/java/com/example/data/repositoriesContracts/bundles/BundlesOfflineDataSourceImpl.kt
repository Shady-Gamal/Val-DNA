package com.example.data.repositoriesContracts.bundles

import android.util.Log
import com.example.data.database.ValorantDatabase
import com.example.data.model.toBundleItemDTO
import com.example.domain.entities.BundleItemDTO
import com.example.domain.entities.Resource
import com.example.domain.repository.BundlesOfflineDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class BundlesOfflineDataSourceImpl @Inject constructor(val valorantDatabase: ValorantDatabase) :
    BundlesOfflineDataSource {
    override suspend fun getBundles(): Flow<Resource<List<BundleItemDTO>>> {

        return flow<Resource<List<BundleItemDTO>>> {
            emit( Resource.Success(valorantDatabase.getBundlesDao().getBundles().map{
                it.toBundleItemDTO()
            }
            ))
        }.onStart {
            emit(Resource.Loading())
        }.catch {
            emit(Resource.Error(it.message ?: "error"))
        }
    }
    }