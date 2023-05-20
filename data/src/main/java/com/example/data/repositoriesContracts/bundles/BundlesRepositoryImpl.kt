package com.example.data.repositoriesContracts.bundles


import android.content.Context
import com.example.data.util.isOnline
import com.example.domain.entities.BundleItemDTO
import com.example.domain.entities.Resource
import com.example.domain.repository.BundlesOfflineDataSource
import com.example.domain.repository.BundlesOnlineDataSource
import com.example.domain.repository.BundlesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BundlesRepositoryImpl @Inject constructor(val bundlesOnlineDataSource: BundlesOnlineDataSource,
                                                val bundlesOfflineDataSource: BundlesOfflineDataSource,
val context: Context) : BundlesRepository {
    override suspend fun getBundles(): Flow<Resource<List<BundleItemDTO>>> {


        if (isOnline(context)){
            bundlesOnlineDataSource.getBundles()
            return bundlesOfflineDataSource.getBundles()

        }else{
            return bundlesOfflineDataSource.getBundles()

        }

    }
    }
