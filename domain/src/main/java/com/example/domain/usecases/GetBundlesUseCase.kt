package com.example.domain.usecases

import com.example.domain.entities.BundleItemDTO
import com.example.domain.entities.MapItemDTO
import com.example.domain.entities.Resource
import com.example.domain.entities.Resource.Error
import com.example.domain.repository.BundlesRepository
import com.example.domain.repository.MapsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetBundlesUseCase @Inject constructor(val bundlesRepository: BundlesRepository)    {
     suspend operator fun invoke() : Flow<Resource<List<BundleItemDTO>>> {
// no suspend for flow it's catchable without 
        return bundlesRepository.getBundles().map { resource ->
            if (resource is Resource.Success){
                Resource.Success(resource.data ?: listOf())
            }else{
                resource
            }
        }
    }
}