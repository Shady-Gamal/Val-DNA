package com.example.data.repositoriesContracts.weapons

import com.example.data.database.ValorantDatabase
import com.example.data.model.toWeaponItemDTO
import com.example.domain.entities.Resource
import com.example.domain.entities.WeaponItemDTO
import com.example.domain.repository.WeaponsOfflineDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class WeaponsOfflineDataSourceImpl @Inject constructor(val valorantDatabase: ValorantDatabase
) : WeaponsOfflineDataSource {
    override suspend fun getWeapons(): Flow<Resource<List<WeaponItemDTO>>> {

        val resource = valorantDatabase.getWeaponsDAO().getWeapons()

        return flow<Resource<List<WeaponItemDTO>>> {

            val successfulResponse = Resource.Success(resource.map {

                it.toWeaponItemDTO()
            })
            emit(successfulResponse)
        }.onStart {
            emit(Resource.Loading())
        }.catch {
            emit(Resource.Error(it.message ?: "error has occured") )
        }

    }
}