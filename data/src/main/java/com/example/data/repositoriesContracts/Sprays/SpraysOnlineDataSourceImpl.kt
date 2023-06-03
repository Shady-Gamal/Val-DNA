package com.example.data.repositoriesContracts.Sprays

import android.content.Context
import android.widget.Toast
import com.example.data.database.ValorantDatabase
import com.example.data.model.toSprayItemDTO
import com.example.data.repositoriesContracts.WebServices
import com.example.domain.entities.Resource
import com.example.domain.entities.SprayItemDTO
import com.example.domain.repository.SpraysOnlineDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class SpraysOnlineDataSourceImpl @Inject constructor(val webServices: WebServices,
val valorantDatabase: ValorantDatabase,
val context: Context) : SpraysOnlineDataSource {
    override suspend fun getSprays() {


        try {


            val response = webServices.getSprays()

            response.data?.let { valorantDatabase.getSpraysDao().saveSprays(it) }
        }
        catch (ex : Exception){


        }
    }
}