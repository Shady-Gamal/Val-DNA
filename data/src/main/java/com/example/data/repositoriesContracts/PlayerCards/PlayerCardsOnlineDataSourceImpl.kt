package com.example.data.repositoriesContracts.PlayerCards

import android.content.Context
import android.widget.Toast
import com.example.data.database.ValorantDatabase
import com.example.data.model.toPlayerCardItemDTO
import com.example.data.repositoriesContracts.WebServices
import com.example.domain.entities.PlayerCardItemDTO
import com.example.domain.entities.Resource
import com.example.domain.repository.PlayerCardsOnlineDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class PlayerCardsOnlineDataSourceImpl @Inject constructor(val webServices: WebServices,
val valorantDatabase: ValorantDatabase,
val context: Context) : PlayerCardsOnlineDataSource {
    override suspend fun getPlayerCards() {


        try {


            val response = webServices.getPlayerCards()

            response.data?.let { valorantDatabase.getPlayerCardsDao().savePlayerCards(it) }
        }
        catch (ex : Exception){

            Toast.makeText(context,"something is wrong with the server", Toast.LENGTH_LONG  ).show()

        }

    }

}