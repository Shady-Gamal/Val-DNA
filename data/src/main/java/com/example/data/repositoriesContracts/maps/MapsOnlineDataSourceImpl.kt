package com.example.data.repositoriesContracts.maps

import android.content.Context
import android.widget.Toast
import com.example.data.database.ValorantDatabase
import com.example.data.model.toMapItemDTO
import com.example.data.repositoriesContracts.WebServices
import com.example.domain.entities.MapItemDTO
import com.example.domain.entities.Resource
import com.example.domain.repository.MapsOnlineDataSource
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class MapsOnlineDataSourceImpl @Inject constructor(val webServices: WebServices,
val valorantDatabase: ValorantDatabase,
val context: Context) :  MapsOnlineDataSource{
    override suspend fun getMaps(){

        try {


            val response = webServices.getMaps()
            response.data?.let { valorantDatabase.getMapsDao().saveMaps(it) }
        }
        catch (ex : Exception){

            Toast.makeText(context,"something is wrong with the server", Toast.LENGTH_LONG  ).show()
        }

    }
    }
