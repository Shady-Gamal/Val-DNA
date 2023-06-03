package com.example.domain.repository

import com.example.domain.entities.AgentItemDTO
import com.example.domain.entities.Resource
import com.example.domain.entities.WeaponItemDTO
import kotlinx.coroutines.flow.Flow

interface WeaponsRepository {

    suspend fun getWeapons() : Flow<Resource<List<WeaponItemDTO>>>
    suspend fun getWeaponsByUUID(uuid: String) : Flow<Resource<WeaponItemDTO>>


}
interface WeaponsOnlineDataSource{

    suspend fun getWeapons()

}

interface WeaponsOfflineDataSource{

    suspend fun getWeapons() : Flow<Resource<List<WeaponItemDTO>>>
    suspend fun getWeaponsByUUID(uuid : String) : Flow<Resource<WeaponItemDTO>>


}