package com.example.data.repositoriesContracts.buddies

import android.content.Context
import android.widget.Toast
import com.example.data.database.ValorantDatabase
import com.example.data.model.toBuddyItemDTO
import com.example.data.repositoriesContracts.WebServices
import com.example.domain.entities.BuddyItemDTO
import com.example.domain.entities.Resource
import com.example.domain.repository.BuddiesOnlineDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class BuddiesOnlineDataSourceImpl @Inject constructor(val webServices: WebServices,
val valorantDatabase: ValorantDatabase,
val context : Context) : BuddiesOnlineDataSource {
    override suspend fun getBuddies() {


        try {

            val response = webServices.getBuddies()

            response.data?.let { valorantDatabase.getBuddiesDao().saveBuddies(it) }
        }
        catch (ex: Exception){

            Toast.makeText(context,"something is wrong with the server", Toast.LENGTH_LONG  ).show()
        }



        }
    }
