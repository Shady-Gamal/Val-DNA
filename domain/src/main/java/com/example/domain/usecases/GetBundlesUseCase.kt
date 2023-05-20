package com.example.domain.usecases

import com.example.domain.entities.BundleItemDTO
import com.example.domain.entities.MapItemDTO
import com.example.domain.entities.Resource
import com.example.domain.repository.BundlesRepository
import com.example.domain.repository.MapsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBundlesUseCase @Inject constructor(val bundlesRepository: BundlesRepository)    {
    suspend operator fun invoke() : Flow<Resource<List<BundleItemDTO>>> {

        return bundlesRepository.getBundles()
    }
}