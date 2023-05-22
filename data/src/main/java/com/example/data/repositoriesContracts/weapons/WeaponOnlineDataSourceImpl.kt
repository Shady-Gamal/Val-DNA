package com.example.data.repositoriesContracts.weapons

import com.example.data.database.ValorantDatabase
import com.example.data.model.toWeaponItemDTO
import com.example.data.repositoriesContracts.WebServices
import com.example.domain.entities.Resource
import com.example.domain.entities.WeaponItemDTO
import com.example.domain.repository.WeaponsOnlineDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class WeaponOnlineDataSourceImpl @Inject constructor(val webServices: WebServices,
val valorantDatabase: ValorantDatabase) : WeaponsOnlineDataSource {
    override suspend fun getWeapons(): Flow<Resource<List<WeaponItemDTO>>> {
        val response = webServices.getWeapons()

        response.data?.let { valorantDatabase.getWeaponsDao().saveWeapons(it) }

        return flow<Resource<List<WeaponItemDTO>>>{

            val successfulResponse = Resource.Success(response.data?.map {
                it.toWeaponItemDTO()
            }!!)

            emit(successfulResponse)



        }.onStart {
            emit(Resource.Loading())
        }.catch {

            emit(Resource.Error(it.message ?: "An error has occured"))
        }
    }
}