package com.example.data.repositoriesContracts.weapons

import android.content.Context
import com.example.data.util.isOnline
import com.example.domain.entities.Resource
import com.example.domain.entities.WeaponItemDTO
import com.example.domain.repository.WeaponsOfflineDataSource
import com.example.domain.repository.WeaponsOnlineDataSource
import com.example.domain.repository.WeaponsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeaponsRepositoryImpl @Inject constructor(val weaponsOnlineDataSource: WeaponsOnlineDataSource,
                                              val  weaponsOfflineDataSource: WeaponsOfflineDataSource,
val context: Context) : WeaponsRepository {
    override suspend fun getWeapons(): Flow<Resource<List<WeaponItemDTO>>> {
        if (isOnline(context)){

            weaponsOnlineDataSource.getWeapons()
            return weaponsOfflineDataSource.getWeapons()

        }else{
            return weaponsOfflineDataSource.getWeapons()

        }
    }
}