package com.example.data.repositoriesContracts.weapons

import android.content.Context
import android.widget.Toast
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

class WeaponsOnlineDataSourceImpl @Inject constructor(
    val webServices: WebServices,
    val valorantDatabase: ValorantDatabase,
    val context: Context
) : WeaponsOnlineDataSource {
    override suspend fun getWeapons(){

        try {


            val response = webServices.getWeapons()

            response.data?.let { valorantDatabase.getWeaponsDao().saveWeapons(it) }
        }
        catch (ex : Exception){

            Toast.makeText(context,"something is wrong with the server", Toast.LENGTH_LONG  ).show()
        }

    }
}