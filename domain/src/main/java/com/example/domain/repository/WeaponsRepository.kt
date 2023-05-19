package com.example.domain.repository

import com.example.domain.entities.Resource
import com.example.domain.entities.WeaponItemDTO
import kotlinx.coroutines.flow.Flow

interface WeaponsRepository {

    suspend fun getWeapons() : Flow<Resource<List<WeaponItemDTO>>>

}
interface WeaponsOnlineDataSource{

    suspend fun getWeapons() : Flow<Resource<List<WeaponItemDTO>>>

}