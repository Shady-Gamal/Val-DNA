package com.example.domain.usecases

import com.example.domain.entities.MapItemDTO
import com.example.domain.entities.Resource
import com.example.domain.repository.MapsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMapsUseCase @Inject constructor(val mapsRepository: MapsRepository)    {
    suspend operator fun invoke() : Flow<Resource<List<MapItemDTO>>>{

       return mapsRepository.getMaps()
    }
}