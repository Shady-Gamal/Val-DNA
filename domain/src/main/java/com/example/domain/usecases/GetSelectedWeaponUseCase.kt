package com.example.domain.usecases

import com.example.domain.entities.Resource
import com.example.domain.entities.WeaponItemDTO
import com.example.domain.repository.WeaponsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSelectedWeaponUseCase @Inject constructor(private val weaponsRepository: WeaponsRepository) {

    suspend operator fun invoke(uuid : String) : Flow<Resource<WeaponItemDTO>> {

        return weaponsRepository.getWeaponsByUUID(uuid)
    }
}