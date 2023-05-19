package com.example.data.repositoriesContracts.weapons

import com.example.domain.entities.Resource
import com.example.domain.entities.WeaponItemDTO
import com.example.domain.repository.WeaponsOnlineDataSource
import com.example.domain.repository.WeaponsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeaponsRepositoryImpl @Inject constructor(val weaponsOnlineDataSource: WeaponsOnlineDataSource) : WeaponsRepository {
    override suspend fun getWeapons(): Flow<Resource<List<WeaponItemDTO>>> {
        return weaponsOnlineDataSource.getWeapons()
    }
}