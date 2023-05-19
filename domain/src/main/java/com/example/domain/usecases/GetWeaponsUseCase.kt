package com.example.domain.usecases

import com.example.domain.entities.Resource
import com.example.domain.entities.WeaponItemDTO
import com.example.domain.repository.WeaponsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWeaponsUseCase @Inject constructor(val weaponsRepository: WeaponsRepository) {

    suspend operator fun invoke() : Flow<Resource<List<WeaponItemDTO>>>{

        return weaponsRepository.getWeapons()

    }
}